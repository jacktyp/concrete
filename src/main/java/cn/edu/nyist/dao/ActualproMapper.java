package cn.edu.nyist.dao;

import cn.edu.nyist.model.Actualpro;
import cn.edu.nyist.model.ActualproExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActualproMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(ActualproExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(ActualproExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(Actualpro record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Actualpro record);

    /**
     *
     * @mbg.generated
     */
    List<Actualpro> selectByExample(ActualproExample example);

    /**
     *
     * @mbg.generated
     */
    Actualpro selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Actualpro record, @Param("example") ActualproExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Actualpro record, @Param("example") ActualproExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Actualpro record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Actualpro record);
}