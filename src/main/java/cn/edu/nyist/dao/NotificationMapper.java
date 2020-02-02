package cn.edu.nyist.dao;

import cn.edu.nyist.model.Notification;
import cn.edu.nyist.model.NotificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotificationMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(NotificationExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(NotificationExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(Notification record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Notification record);

    /**
     *
     * @mbg.generated
     */
    List<Notification> selectByExample(NotificationExample example);

    /**
     *
     * @mbg.generated
     */
    Notification selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Notification record, @Param("example") NotificationExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Notification record, @Param("example") NotificationExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Notification record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Notification record);
}