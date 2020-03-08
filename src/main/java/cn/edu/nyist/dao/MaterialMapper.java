package cn.edu.nyist.dao;

import cn.edu.nyist.model.Material;
import cn.edu.nyist.model.MaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(MaterialExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(MaterialExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(Material record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Material record);

    /**
     *
     * @mbg.generated
     */
    List<Material> selectByExample(MaterialExample example);

    /**
     *
     * @mbg.generated
     */
    Material selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Material record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Material record);
}