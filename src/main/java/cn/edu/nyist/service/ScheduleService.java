package cn.edu.nyist.service;

import cn.edu.nyist.model.Schedule;
import cn.edu.nyist.model.ScheduleDTO;

import java.util.List;

/**
 * @ClassName ScheduleService
 * @Description 计划生产
 * @Date 2020/2/28 13:55
 * @Created by typ
 */
public interface ScheduleService {

    /**
     * 当天未生产
     * @return
     */
    List<Schedule> dayOfNoproduction();

    /**
     * 当月未生产 近一个月
     * @return
     */
    List<Schedule> monthOfNoproduction();

    /**
     * 根据时间查询数据
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    List<Schedule> getScheduleInDate(Long startTime,Long endTime);

    /**
     * 查询所有
     * @return
     */
    List<ScheduleDTO> findAllSchedule();

    /**
     * 增加
     * @param scheduleDTO
     */
    void addScheduleDTO(ScheduleDTO scheduleDTO);

    List<ScheduleDTO> findAllScheduleByState();

    void delete(Integer id);

    void update(ScheduleDTO scheduleDTO);
}
