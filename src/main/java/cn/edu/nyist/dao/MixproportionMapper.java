package cn.edu.nyist.dao;

import cn.edu.nyist.model.Mixproportion;
import cn.edu.nyist.model.MixproportionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MixproportionMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(MixproportionExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(MixproportionExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(Mixproportion record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Mixproportion record);

    /**
     *
     * @mbg.generated
     */
    List<Mixproportion> selectByExample(MixproportionExample example);

    /**
     *
     * @mbg.generated
     */
    Mixproportion selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Mixproportion record, @Param("example") MixproportionExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Mixproportion record, @Param("example") MixproportionExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Mixproportion record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Mixproportion record);
}