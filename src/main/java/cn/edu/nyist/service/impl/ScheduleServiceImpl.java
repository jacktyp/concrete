package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.NotificationMapper;
import cn.edu.nyist.dao.ScheduleMapper;
import cn.edu.nyist.model.*;
import cn.edu.nyist.service.MaterialService;
import cn.edu.nyist.service.ScheduleService;
import cn.edu.nyist.util.DateUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private NotificationMapper notificationMapper;
    @Autowired
    private MaterialService materialService;
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

    @Override
    public List<ScheduleDTO> findAllSchedule() {
        List<Schedule> schedules = scheduleMapper.selectByExample(new ScheduleExample());
        List<ScheduleDTO> ScheduleDTOList = Lists.newArrayList();
        schedules.forEach(p->ScheduleDTOList.add(new ScheduleDTO().transfer(p)));
        return ScheduleDTOList;
    }

    @Override
    public List<ScheduleDTO> findAllScheduleByState() {
        List<Schedule> schedules = scheduleMapper.selectByExample(new ScheduleExample());
        List<ScheduleDTO> ScheduleDTOList = Lists.newArrayList();
        schedules.forEach(p->ScheduleDTOList.add(new ScheduleDTO().transfer(p)));
        return ScheduleDTOList.stream().filter(p->p.getState() == "0").collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        scheduleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ScheduleDTO scheduleDTO) {
        Schedule schedule = new ScheduleDTO().transferBack(scheduleDTO);
        scheduleMapper.updateByPrimaryKey(schedule);
    }

    @Override
    public void addScheduleDTO(ScheduleDTO scheduleDTO) {
        Integer notificationId = scheduleDTO.getNotificationId();
        Notification notification = notificationMapper.selectByPrimaryKey(notificationId);
        Integer stoneamount = notification.getStoneamount();
        Integer sandamount = notification.getSandamount();
        Integer cementamount = notification.getCementamount();
        Integer additiveamount = notification.getAdditiveamount();

        Material material = materialService.findOne().get(0);
        if (stoneamount > material.getStone()){
            throw new RuntimeException("<script>alert('剩余量不足')<script>");
        }
        if (sandamount > material.getSand()){
            throw new RuntimeException("剩余量不足");
        }
        if (cementamount > material.getCement()){
            throw new RuntimeException("剩余量不足");
        }
        if (additiveamount > material.getAdditive()){
            throw new RuntimeException("剩余量不足");
        }
        Schedule schedule = new ScheduleDTO().transferBack(scheduleDTO);
        schedule.setState("0");
        scheduleMapper.insert(schedule);

        notification.setMixproportionId(1);
        notificationMapper.updateByPrimaryKey(notification);
    }


}
