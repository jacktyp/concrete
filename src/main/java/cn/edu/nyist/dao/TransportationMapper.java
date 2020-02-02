package cn.edu.nyist.dao;

import cn.edu.nyist.model.Transportation;
import cn.edu.nyist.model.TransportationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransportationMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(TransportationExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(TransportationExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(Transportation record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Transportation record);

    /**
     *
     * @mbg.generated
     */
    List<Transportation> selectByExample(TransportationExample example);

    /**
     *
     * @mbg.generated
     */
    Transportation selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Transportation record, @Param("example") TransportationExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Transportation record, @Param("example") TransportationExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Transportation record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Transportation record);
}