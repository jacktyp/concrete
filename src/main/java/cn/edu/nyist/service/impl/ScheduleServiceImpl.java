package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.ScheduleMapper;
import cn.edu.nyist.model.Schedule;
import cn.edu.nyist.model.ScheduleExample;
import cn.edu.nyist.service.ScheduleService;
import cn.edu.nyist.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ScheduleServiceImpl
 * @Description TODO
 * @Date 2020/2/28 14:43
 * @Created by typ
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public List<Schedule> dayOfNoproduction() {
        Long dayTimeInMillis = DateUtil.dayTimeInMillis();
        Long nextDayTimeInMillis = DateUtil.nextDayTimeInMillis();
        //条件查询
        ScheduleExample scheduleExample = new ScheduleExample();
        ScheduleExample.Criteria criteria = scheduleExample.createCriteria();
        criteria.andRegistranttimeGreaterThanOrEqualTo(dayTimeInMillis);
        criteria.andRegistranttimeLessThan(nextDayTimeInMillis);
        List<Schedule> scheduleList = scheduleMapper.selectByExample(scheduleExample);
        return scheduleList;
    }

    @Override
    public List<Schedule> monthOfNoproduction() {
        Long monthStartTime = DateUtil.getDateStampCutDay(30);
        Long monthEndTime = DateUtil.nextDayTimeInMillis();
        //条件查询
        ScheduleExample scheduleExample = new ScheduleExample();
        ScheduleExample.Criteria criteria = scheduleExample.createCriteria();
        criteria.andRegistranttimeGreaterThanOrEqualTo(monthStartTime);
        criteria.andRegistranttimeLessThan(monthEndTime);
        List<Schedule> scheduleList = scheduleMapper.selectByExample(scheduleExample);
        return scheduleList;
    }

    @Override
    public List<Schedule> getScheduleInDate(Long startTime, Long endTime) {
        ScheduleExample scheduleExample = new ScheduleExample();
        ScheduleExample.Criteria criteria = scheduleExample.createCriteria();
        criteria.andRegistranttimeGreaterThanOrEqualTo(startTime);
        criteria.andRegistranttimeLessThanOrEqualTo(endTime);
        List<Schedule> scheduleList = scheduleMapper.selectByExample(scheduleExample);
        return scheduleList;
    }
}
