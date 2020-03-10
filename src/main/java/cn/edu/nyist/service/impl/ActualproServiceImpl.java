package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.ActualproMapper;
import cn.edu.nyist.dao.ScheduleMapper;
import cn.edu.nyist.model.*;
import cn.edu.nyist.service.ActualproService;
import cn.edu.nyist.service.ContractService;
import cn.edu.nyist.service.ScheduleService;
import cn.edu.nyist.util.DateUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName ActualproServiceImpl
 * @Description TODO
 * @Date 2020/2/28 13:57
 * @Created by typ
 */
@Service
public class ActualproServiceImpl implements ActualproService {

    @Autowired
    private ActualproMapper actualproMapper;
    @Autowired
    private ContractService contractService;
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public Integer dayOfproduction() {
        //当天
        Long dayTime = DateUtil.dayTimeInMillis();
        //下一天
        Long nextDayTime = DateUtil.nextDayTimeInMillis();
        //条件查询
        ActualproExample actualproExample = new ActualproExample();
        ActualproExample.Criteria criteria = actualproExample.createCriteria();
        criteria.andRegistranttimeGreaterThanOrEqualTo(dayTime);
        criteria.andRegistranttimeLessThan(nextDayTime);
        List<Actualpro> actualproList = actualproMapper.selectByExample(actualproExample);
        Integer concreteamountNum = actualproList.stream()
                .filter(p->p.getConcreteamount() != null)
                .collect(Collectors.summingInt(Actualpro::getConcreteamount));
        return concreteamountNum;
    }

    @Override
    public Integer monthOfproduction() {
        Long monthStartTime = DateUtil.getDateStampCutDay(30);
        Long monthEndTime = DateUtil.nextDayTimeInMillis();
        //条件查询
        ActualproExample actualproExample = new ActualproExample();
        ActualproExample.Criteria criteria = actualproExample.createCriteria();
        criteria.andRegistranttimeGreaterThanOrEqualTo(monthStartTime);
        criteria.andRegistranttimeLessThan(monthEndTime);
        List<Actualpro> actualproList = actualproMapper.selectByExample(actualproExample);
        Integer concreteamountNum = actualproList.stream()
                .filter(p->p.getConcreteamount() != null)
                .collect(Collectors.summingInt(Actualpro::getConcreteamount));
        return concreteamountNum;
    }

    @Override
    public List<Actualpro> getActualproInDate(Long dailyStartTime, Long endTime) {
        ActualproExample actualproExample = new ActualproExample();
        ActualproExample.Criteria criteria = actualproExample.createCriteria();
        criteria.andRegistranttimeGreaterThanOrEqualTo(dailyStartTime);
        criteria.andRegistranttimeLessThanOrEqualTo(endTime);
        List<Actualpro> actualproList = actualproMapper.selectByExample(actualproExample);
        return actualproList;
    }

    @Override
    public List<Actualpro> findAll() {
        ActualproExample actualproExample = new ActualproExample();
        List<Actualpro> actualproList = actualproMapper.selectByExample(actualproExample);
        return actualproList;
    }

    @Override
    public List<ConcreteBackList> findConcreteCost() throws Exception {
        List<Actualpro> actualproList = actualproMapper.selectByExample(new ActualproExample());
        //合同集合
        List<ContractDTO> contractDTOList = contractService.findAllContract();
        Map<Integer, Double> idPriceMaps = contractDTOList.stream()
                .collect(Collectors.toMap(ContractDTO::getId, ContractDTO::getPrice));
        //数据转换
        List<ActualproDTO> actualproDTOList = Lists.newArrayList();
        actualproList.forEach(p->actualproDTOList.add(new ActualproDTO().transfer(p)));
        Map<String, List<ActualproDTO>> timeMaps = actualproDTOList.stream()
                .collect(Collectors.groupingBy(ActualproDTO::getRegistranttime));

        //返回数据
        List<ConcreteBackList> concreteBackListList = Lists.newArrayList();

        for (Map.Entry<String, List<ActualproDTO>> entry : timeMaps.entrySet()){
            String time = entry.getKey();
            Double allPrice = 0.0;
            List<ActualproDTO> actualproDTOS = entry.getValue();
            for (ActualproDTO actualproDTO : actualproDTOS) {
                Integer contractId = actualproDTO.getContractId();
                Double price = idPriceMaps.get(contractId);
                allPrice += price;
            }
            ConcreteBackList concreteBackList = new ConcreteBackList();
            concreteBackList.setDate(time);
            concreteBackList.setPrice(String.valueOf(allPrice));
            concreteBackListList.add(concreteBackList);
        }
        return concreteBackListList;
    }

    @Override
    public List<ActualproDTO> findAllActualpro() {
        List<Actualpro> actualpros = actualproMapper.selectByExample(new ActualproExample());
        List<ActualproDTO> actualproDTOList = Lists.newArrayList();
        actualpros.forEach(p->actualproDTOList.add(new ActualproDTO().transfer(p)));
        return actualproDTOList;
    }

    @Override
    public void addActualproDTO(ActualproDTO actualproDTO) {
        Actualpro actualpro = new ActualproDTO().transferBack(actualproDTO);
        Integer scheduleId = actualpro.getScheduleId();
        Schedule schedule = scheduleMapper.selectByPrimaryKey(scheduleId);
        if (schedule.getState().equals("0")){
            actualproMapper.insert(actualpro);
        }else{
            throw new RuntimeException("添加失败");
        }

    }

    @Override
    public void delete(Integer id) {
        actualproMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ActualproDTO actualproDTO) {
        Actualpro actualpro = new ActualproDTO().transferBack(actualproDTO);
        actualproMapper.updateByPrimaryKey(actualpro);
    }
}
