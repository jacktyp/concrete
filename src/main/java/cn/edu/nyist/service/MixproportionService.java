package cn.edu.nyist.service;

import cn.edu.nyist.model.MixproportionDTO;

import java.util.List;

/**
 * @Classname MixproportionService
 * @Description 配合比
 * @Date 2020/2/10 10:37
 * @Created by typ
 */
public interface MixproportionService {

    /**
     * 根据ID获取配合比信息
     * @param id
     * @return
     */
    MixproportionDTO getMixproportion(Integer id) throws Exception;

    /**
     * 查询所有配合比
     * @return
     */
    List<MixproportionDTO> findAllMixproportion() throws Exception;

    /**
     * 增加配合比
     * @param mixproportionDTO
     */
    void addMixproportion(MixproportionDTO mixproportionDTO) throws Exception;

    /**
     * 更新配合比
     * @param mixproportionDTO
     */
    void updateMixproportion(MixproportionDTO mixproportionDTO) throws Exception;

    /**
     * 删除配合比
     * @param id
     * @throws Exception
     */
    void deleteMixproportion(Integer id) throws Exception;
}
