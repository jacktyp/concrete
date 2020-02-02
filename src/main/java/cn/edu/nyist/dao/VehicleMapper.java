package cn.edu.nyist.dao;

import cn.edu.nyist.model.Vehicle;
import cn.edu.nyist.model.VehicleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(VehicleExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(VehicleExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(Vehicle record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Vehicle record);

    /**
     *
     * @mbg.generated
     */
    List<Vehicle> selectByExample(VehicleExample example);

    /**
     *
     * @mbg.generated
     */
    Vehicle selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Vehicle record, @Param("example") VehicleExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Vehicle record, @Param("example") VehicleExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Vehicle record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Vehicle record);
}