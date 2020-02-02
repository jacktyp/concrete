package cn.edu.nyist.dao;

import cn.edu.nyist.model.Procurement;
import cn.edu.nyist.model.ProcurementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcurementMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(ProcurementExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(ProcurementExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(Procurement record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Procurement record);

    /**
     *
     * @mbg.generated
     */
    List<Procurement> selectByExample(ProcurementExample example);

    /**
     *
     * @mbg.generated
     */
    Procurement selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Procurement record, @Param("example") ProcurementExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Procurement record, @Param("example") ProcurementExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Procurement record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Procurement record);
}