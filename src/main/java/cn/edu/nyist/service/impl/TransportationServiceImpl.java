package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.TransportationMapper;
import cn.edu.nyist.model.*;
import cn.edu.nyist.service.TransportationService;
import cn.edu.nyist.service.VehicleService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName TransportationServiceImpl
 * @Description TODO
 * @Date 2020/3/8 9:52
 * @Created by typ
 */
@Service
public class TransportationServiceImpl implements TransportationService {

    //车辆四种类型
    /*private static final String ONE_TYPE = "1";
    private static final String TWO_TYPE = "2";
    private static final String THREE_TYPE = "3";
    private static final String FOUR_TYPE = "4";*/

    @Autowired
    private TransportationMapper transportationMapper;
    @Autowired
    private VehicleService vehicleService;

    @Override
    public List<Transportation> findTransportationInDate(Long startTime, Long endTime) {
        TransportationExample transportationExample = new TransportationExample();
        TransportationExample.Criteria criteria = transportationExample.createCriteria();
        criteria.andRegistranttimeGreaterThanOrEqualTo(startTime);
        criteria.andRegistranttimeLessThanOrEqualTo(endTime);
        List<Transportation> transportationList = transportationMapper.selectByExample(transportationExample);
        return transportationList;
    }

    @Override
    public List<TransportationBackList> findVehicleCost() {
        List<Transportation> transportationList = transportationMapper.selectByExample(new TransportationExample());

        List<TransportationBackList> transportationBackListList = Lists.newArrayList();
        //转换数据
        List<TransportationDTO> transportationDTOList = Lists.newArrayList();
        transportationList.forEach(p -> transportationDTOList.add(new TransportationDTO().transfer(p)));
        //车辆集合
        List<Vehicle> allVehicleList = vehicleService.findAll();
        Map<Integer, Vehicle> idMaps = allVehicleList.stream().collect(Collectors.toMap(Vehicle::getId, p -> p));
        //按时间分组
        Map<String, List<TransportationDTO>> timeMaps = transportationDTOList.stream()
                .collect(Collectors.groupingBy(TransportationDTO::getRegistranttime));

        for (Map.Entry<String, List<TransportationDTO>> entry : timeMaps.entrySet()) {
            String time = entry.getKey();
            List<TransportationDTO> transportationDTOS = entry.getValue();
            Double allPrice = 0.0;
            for (TransportationDTO transportationDTO : transportationDTOS) {
                Integer vehicleId = transportationDTO.getVehicleId();
                Vehicle vehicle = idMaps.get(vehicleId);
                Double price = vehicle.getPrice();
                allPrice += price;
            }
            TransportationBackList transportationBackList = new TransportationBackList();
            transportationBackList.setDate(time);
            transportationBackList.setPrice(String.valueOf(allPrice));
        }
        return transportationBackListList;
    }
}
