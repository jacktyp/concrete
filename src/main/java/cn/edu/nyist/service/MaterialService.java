package cn.edu.nyist.service;

import cn.edu.nyist.model.Material;

import java.util.List;

/**
 * @ClassName MaterialService
 * @Description 原材料
 * @Date 2020/3/8 11:05
 * @Created by typ
 */
public interface MaterialService {
    /**
     * 拿到一个
     * @return
     */
    List<Material> findOne();

    /**
     * 插入
     * @param material
     */
    void addMaterial(Material material);
}
