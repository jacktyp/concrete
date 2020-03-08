package cn.edu.nyist.dao;

import cn.edu.nyist.model.Financestic;
import cn.edu.nyist.model.FinancesticExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinancesticMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(FinancesticExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(FinancesticExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(Financestic record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Financestic record);

    /**
     *
     * @mbg.generated
     */
    List<Financestic> selectByExample(FinancesticExample example);

    /**
     *
     * @mbg.generated
     */
    Financestic selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Financestic record, @Param("example") FinancesticExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Financestic record, @Param("example") FinancesticExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Financestic record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Financestic record);
}