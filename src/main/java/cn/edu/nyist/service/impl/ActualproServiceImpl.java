package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.ActualproMapper;
import cn.edu.nyist.model.Actualpro;
import cn.edu.nyist.model.ActualproExample;
import cn.edu.nyist.service.ActualproService;
import cn.edu.nyist.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
