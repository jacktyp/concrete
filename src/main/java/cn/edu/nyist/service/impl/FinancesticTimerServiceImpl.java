package cn.edu.nyist.service.impl;

import cn.edu.nyist.model.*;
import cn.edu.nyist.service.*;
import cn.edu.nyist.util.DateUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName FinancesticTimerServiceImpl
 * @Description TODO
 * @Date 2020/3/8 9:09
 * @Created by typ
 */
@Service("financesticTimerServiceImpl")
public class FinancesticTimerServiceImpl implements FinancesticTimerService {

    @Autowired
    private ActualproService actualproService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private ProcureService procureService;
    @Autowired
    private TransportationService transportationService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private FinancesticService financesticService;
    @Override
    public void setDataToFinancestic() {
        Long lastDayStartMillis = DateUtil.lastDayStartMillis();
        Long lastDayEndMillis = DateUtil.lastDayEndMillis();

        Financestic financestic = new Financestic();
        financestic.setTime(lastDayStartMillis);

        //收入
        Double priceCout = 0.0;
        List<Actualpro> actualproInDate = actualproService.getActualproInDate(lastDayStartMillis, lastDayEndMillis);
        if (!CollectionUtils.isEmpty(actualproInDate)){
            //合同ID集合
            List<Integer> contractIdList = Lists.newArrayList();
            actualproInDate.forEach(p->contractIdList.add(p.getContractId()));
            Map<Integer,Double> contractPriceMap = contractService.getContractByIdList(contractIdList).stream()
                                                                .collect(Collectors.toMap(Contract::getId,Contract::getPrice));
            for (Actualpro actualpro : actualproInDate) {
                Integer contractId = actualpro.getContractId();
                Integer concreteamount = actualpro.getConcreteamount();
                if (concreteamount != null){
                    Double contractPrice = contractPriceMap.get(contractId);
                    if (contractPrice != null){
                        Double price = concreteamount * contractPrice;
                        priceCout += price;
                    }
                }
            }
        }

        financestic.setIncome(priceCout);
        //支出
        List<Procurement> procurementList = procureService.findProcureInDate(lastDayStartMillis, lastDayEndMillis);
        Double priceMount = 0.0;
        if (!CollectionUtils.isEmpty(procurementList)){
            priceMount = procurementList.stream().collect(Collectors.summingDouble(Procurement::getPriceamount));
        }

        List<Transportation> transportationList = transportationService.findTransportationInDate(lastDayStartMillis, lastDayEndMillis);
        //List<Integer> vehicleIdList = Lists.newArrayList();
        Double vehclePrice = 0.0;
        if (!CollectionUtils.isEmpty(transportationList)){
            //ID
            List<Integer> vehicleIdList = transportationList.stream().map(Transportation::getVehicleId).distinct().collect(Collectors.toList());
            Map<Integer, Long> vehicleIdMap = transportationList.stream().collect(Collectors.groupingBy(Transportation::getVehicleId, Collectors.counting()));
            //vehcle
            List<Vehicle> vehicleList = vehicleService.findByIds(vehicleIdList);
            Map<Integer, Double> IdPriceMap = vehicleList.stream().collect(Collectors.toMap(Vehicle::getId, Vehicle::getPrice));
            for (Map.Entry<Integer,Long> entry : vehicleIdMap.entrySet()){
                Integer vehcleId = entry.getKey();
                Long count = entry.getValue();
                Double price = IdPriceMap.get(vehcleId);
                if (price != null){
                    Double allPrice = price * count;
                    vehclePrice += allPrice;
                }
            }
        }
        financestic.setExpenditure(priceMount + vehclePrice);
        //利润
        financestic.setProfit(priceCout - (priceMount + vehclePrice));
        financesticService.addFinancestic(financestic);
    }

}
