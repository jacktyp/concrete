package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.MaterialMapper;
import cn.edu.nyist.model.Material;
import cn.edu.nyist.model.MaterialExample;
import cn.edu.nyist.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName MaterialServiceImpl
 * @Description TODO
 * @Date 2020/3/8 11:06
 * @Created by typ
 */
@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialMapper materialMapper;

    @Override
    public List<Material> findOne() {
        List<Material> materialList = materialMapper.selectByExample(new MaterialExample());
        return materialList;
    }

    @Override
    public void addMaterial(Material material) {
        if (material.getId() != null){
            materialMapper.updateByPrimaryKey(material);
        }
        materialMapper.insert(material);
    }
}
