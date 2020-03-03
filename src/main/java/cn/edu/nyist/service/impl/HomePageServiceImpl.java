package cn.edu.nyist.service.impl;

import cn.edu.nyist.model.*;
import cn.edu.nyist.service.ActualproService;
import cn.edu.nyist.service.ContractService;
import cn.edu.nyist.service.HomePageService;
import cn.edu.nyist.service.ScheduleService;
import cn.edu.nyist.util.DateUtil;
import cn.edu.nyist.util.MathUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName HomePageServiceImpl
 * @Description TODO
 * @Date 2020/2/28 13:48
 * @Created by typ
 */
@Service
public class HomePageServiceImpl implements HomePageService {

    /**
     * 未完成标记
     */
    private static final String UNFINISHED = "0";

    /**
     * 减去一天
     */
    private static final Integer ONEDAY = 1;

    /**
     * 0
     */
    private static final String ZEROSTR = "0";


    @Autowired
    private ActualproService actualproService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ContractService contractService;


    @Override
    public HomePageDataDTO getDataList() throws Exception{
        HomePageDataDTO homePageDataDTO = new HomePageDataDTO();
        //1. 生产量
        Integer dayOfproduction = actualproService.dayOfproduction();
        Integer monthOfproduction = actualproService.monthOfproduction();
        homePageDataDTO.setDayOfProduction(dayOfproduction);
        homePageDataDTO.setMonthOfProduction(monthOfproduction);
        //2. 未生产量
        Integer dayNoProduction = 0;
        Integer monthNoProduction = 0;
        //天
        List<Schedule> dayScheduleList = scheduleService.dayOfNoproduction();
        if (!CollectionUtils.isEmpty(dayScheduleList)){
            List<Integer> dayContractIdList = dayScheduleList.stream()
                    .filter(p->p.getState().equals(UNFINISHED))
                    .map(Schedule::getContractId)
                    .collect(Collectors.toList());
            dayNoProduction = contractService.getContractByIds(dayContractIdList);
        }
        homePageDataDTO.setDayOfNoProduction(dayNoProduction);
        //月
        List<Schedule> monthScheduleList = scheduleService.monthOfNoproduction();
        if (!CollectionUtils.isEmpty(monthScheduleList)){
            List<Integer> monthContractIdList = monthScheduleList.stream()
                    .filter(p->p.getState().equals(UNFINISHED))
                    .map(Schedule::getContractId)
                    .collect(Collectors.toList());
            monthNoProduction = contractService.getContractByIds(monthContractIdList);
        }
        homePageDataDTO.setMonthOfNoProduction(monthNoProduction);


        //3. 新增生产量
        Integer newDayProduct = contractService.getDayContractProduction();
        Integer newMonthProduct = contractService.getMonthContractProduction();
        homePageDataDTO.setDayOfNewProduction(newDayProduct);
        homePageDataDTO.setMonthOfNewProduction(newMonthProduct);

        //5. 合同近十天
        Long dateStampCutDay = DateUtil.getDateStampCutDay(9);
        Long dailyStartTime = DateUtil.getDailyStartTime(dateStampCutDay);
        Long endTime = DateUtil.getDailyEndTime(System.currentTimeMillis());
        List<Contract> contractInDateList = contractService.getContractInDate(dailyStartTime, endTime);

        JSONArray contractArray = new JSONArray();
        //计算近十天的和
        contractTenOfSum(contractArray,contractInDateList);
        homePageDataDTO.setContractOfTen(contractArray);

        //6. 计划近十天的和
        JSONArray scheduleArray = new JSONArray();
        List<Schedule> scheduleList = scheduleService.getScheduleInDate(dailyStartTime, endTime);
        List<Contract> contractList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(scheduleList)){
            List<Integer> contractIdList = scheduleList.stream()
                    .map(Schedule::getContractId)
                    .collect(Collectors.toList());
            //合同ID与时间 map  合同ID唯一
            Map<Integer, Long> contractIdMap = scheduleList.stream()
                    .collect(Collectors.toMap(Schedule::getContractId, Schedule::getRegistranttime));
            contractList = contractService.getContractByIdList(contractIdList);
            contractList.forEach(p->{
                Long time = contractIdMap.get(p.getId());
                if (time != null){
                    p.setRegistranttime(time);
                }
            });
        }
        //计算近十天的和
        contractTenOfSum(scheduleArray,contractList);
        homePageDataDTO.setPlanOfTen(scheduleArray);

        //7. 实际生产表中近十天的生产合
        List<Actualpro> actualproList = actualproService.getActualproInDate(dailyStartTime, endTime);
        JSONArray actualArray = new JSONArray();
        actualTenOfSum(actualArray,actualproList);
        homePageDataDTO.setProductOfTen(actualArray);


        //10. 地址分布
        List<ContractDTO> allContractList = contractService.findAllContract();
        Map<String, List<ContractDTO>> contractAddressMap = allContractList.stream()
                .collect(Collectors.groupingBy(p -> p.getAddress()));

        Map<String,String> addrMap = Maps.newHashMap();
        if (!CollectionUtils.isEmpty(contractAddressMap)){
            for (Map.Entry<String, List<ContractDTO>> entry : contractAddressMap.entrySet()){
                String addrName = entry.getKey();
                List<ContractDTO> dtoList = entry.getValue();

                addrMap.put(addrName,MathUtil.backPercent(dtoList.size(),allContractList.size()));
            }
        }
        homePageDataDTO.setAddressDistribution(addrMap);


        //11. 月增加数量
        JSONObject increaseObject = new JSONObject();
        //上月开始结束
        Long lastStartTimes = DateUtil.getDateStampCutMonthStartTime(ONEDAY);
        Long lastEndTimes = DateUtil.getDateStampCutMonthEndTime(ONEDAY);
        //本月开始结束
        Long monthStartTime = DateUtil.getMonthStartTime();
        Long monthEndTime = DateUtil.getMonthEndTime();
        //转换
        List<Contract> contracts = Lists.newArrayList();
        allContractList.forEach(p->contracts.add(new ContractDTO().transferBack(p)));

        if (!CollectionUtils.isEmpty(contracts)){
            Integer lastAmountNum = 0;
            Integer amountNum = 0;
            //上月
            lastAmountNum = contracts.stream()
                    .filter(p->p.getAmount() != null && (p.getRegistranttime() >= lastStartTimes && p.getRegistranttime() <= lastEndTimes))
                    .collect(Collectors.summingInt(Contract::getAmount));
            //本月
            amountNum = contracts.stream()
                    .filter(p->p.getAmount() != null && (p.getRegistranttime() >= monthStartTime && p.getRegistranttime() <= monthEndTime))
                    .collect(Collectors.summingInt(Contract::getAmount));
            //本月大于上月
            Boolean falg = amountNum > lastAmountNum;
            String contractDis = "0";
            if (falg){
                Integer numAll = amountNum - lastAmountNum;
                contractDis = MathUtil.backPercent(numAll,lastAmountNum);
            }
            increaseObject.put("contractDis",contractDis);
        }else {
            increaseObject.put("contractDis",ZEROSTR);
        }

        List<Actualpro> actualpros = actualproService.findAll();
        if (!CollectionUtils.isEmpty(actualpros)){
            Integer lastAmountNum = 0;
            Integer amountNum = 0;
            //上月
            lastAmountNum = actualpros.stream()
                    .filter(p->p.getConcreteamount() != null && (p.getRegistranttime() >= lastStartTimes && p.getRegistranttime() <= lastEndTimes))
                    .collect(Collectors.summingInt(Actualpro::getConcreteamount));
            //本月
            amountNum = actualpros.stream()
                    .filter(p->p.getConcreteamount() != null && (p.getRegistranttime() >= monthStartTime && p.getRegistranttime() <= monthEndTime))
                    .collect(Collectors.summingInt(Actualpro::getConcreteamount));
            //本月大于上月
            Boolean falg = amountNum > lastAmountNum;
            String actualDis = "0";
            if (falg){
                Integer numAll = amountNum - lastAmountNum;
                actualDis = MathUtil.backPercent(numAll,lastAmountNum);
            }
            increaseObject.put("actualDis",actualDis);
        }else {
            increaseObject.put("actualDis",ZEROSTR);
        }
        homePageDataDTO.setIncreaseDistribution(increaseObject);
        return homePageDataDTO;
    }

    public void contractTenOfSum(JSONArray jsonArray,List<Contract> contracts){
        for (int i = 9 ; i>=0 ; i--){
            JSONObject jsonObject = new JSONObject();
            Long dayTimes = DateUtil.getDateStampCutDay(i);
            Long startTimes = DateUtil.getDailyStartTime(dayTimes);
            Long endTimes = DateUtil.getDailyEndTime(dayTimes);
            String time = DateUtil.convertTimeToString(startTimes);
            time = DateUtil.cutBackZero(time);
            Integer amountNum = 0;
            if (!CollectionUtils.isEmpty(contracts)){
                amountNum = contracts.stream()
                        .filter(p->p.getAmount() != null && (p.getRegistranttime() >= startTimes && p.getRegistranttime() <= endTimes))
                        .collect(Collectors.summingInt(Contract::getAmount));
            }
            jsonObject.put("timeToStr",time);
            jsonObject.put("amountNum",amountNum);
            jsonArray.add(jsonObject);
        }
    }

    public void actualTenOfSum(JSONArray jsonArray,List<Actualpro> actualproList){
        for (int i = 9 ; i>=0 ; i--){
            JSONObject jsonObject = new JSONObject();
            Long dayTimes = DateUtil.getDateStampCutDay(i);
            Long startTimes = DateUtil.getDailyStartTime(dayTimes);
            Long endTimes = DateUtil.getDailyEndTime(dayTimes);
            String time = DateUtil.convertTimeToString(startTimes);
            time = DateUtil.cutBackZero(time);
            Integer amountNum = 0;
            if (!CollectionUtils.isEmpty(actualproList)){
                amountNum = actualproList.stream()
                        .filter(p->p.getConcreteamount() != null && (p.getRegistranttime() >= startTimes && p.getRegistranttime() <= endTimes))
                        .collect(Collectors.summingInt(Actualpro::getConcreteamount));
            }
            jsonObject.put("timeToStr",time);
            jsonObject.put("amountNum",amountNum);
            jsonArray.add(jsonObject);
        }
    }

}
