package cn.edu.nyist.dao;

import cn.edu.nyist.model.Contract;
import cn.edu.nyist.model.ContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(ContractExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(ContractExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(Contract record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Contract record);

    /**
     *
     * @mbg.generated
     */
    List<Contract> selectByExample(ContractExample example);

    /**
     *
     * @mbg.generated
     */
    Contract selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Contract record, @Param("example") ContractExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Contract record, @Param("example") ContractExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Contract record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Contract record);
}