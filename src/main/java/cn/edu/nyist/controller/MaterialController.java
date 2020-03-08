package cn.edu.nyist.controller;

import cn.edu.nyist.model.Material;
import cn.edu.nyist.service.MaterialService;
import cn.edu.nyist.util.LayuiUtil;
import cn.edu.nyist.util.MessageConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName MaterialController
 * @Description 原材料
 * @Date 2020/3/8 12:51
 * @Created by typ
 */
@Controller
@RequestMapping("/concrete/material")
public class MaterialController {
    private static final Logger logger = LoggerFactory.getLogger(MaterialController.class);

    @Autowired
    private MaterialService materialService;

    /**
     * 石头、沙子、水泥、添加剂 原材料统计表中个原材料的数量
     * @return
     */
    @RequestMapping(value = "/selectMaterial",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil selectMaterial(){
        try{
            List<Material> materialServiceOne = materialService.findOne();
            if (CollectionUtils.isEmpty(materialServiceOne)){
                return LayuiUtil.newSuccess(new Material().toString());
            }
            return LayuiUtil.newSuccess(materialServiceOne.get(0).toString());
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }

}
