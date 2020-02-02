package cn.edu.nyist.dao;

import cn.edu.nyist.model.Schedule;
import cn.edu.nyist.model.ScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScheduleMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(ScheduleExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(ScheduleExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(Schedule record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Schedule record);

    /**
     *
     * @mbg.generated
     */
    List<Schedule> selectByExample(ScheduleExample example);

    /**
     *
     * @mbg.generated
     */
    Schedule selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Schedule record, @Param("example") ScheduleExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Schedule record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Schedule record);
}