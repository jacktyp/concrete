package cn.edu.nyist.controller;

import cn.edu.nyist.model.HomePageDataDTO;
import cn.edu.nyist.service.HomePageService;
import cn.edu.nyist.util.LayuiUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName HomePageController
 * @Description 首页数据
 * @Date 2020/2/28 13:33
 * @Created by typ
 */
@Controller
@RequestMapping("/concrete/homePage")
public class HomePageController {

    private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);
    @Autowired
    private HomePageService homePageService;

    /**
     * 首页数据集合
     * @return
     */
    @RequestMapping(value = "/dataList",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil dataList(){
        try{
            HomePageDataDTO homePageDataDTO = homePageService.getDataList();
            return LayuiUtil.newSuccess(JSON.toJSONString(homePageDataDTO));
        }catch (Exception e){
            logger.error("首页查询失败");
            return LayuiUtil.newFaild("首页查询失败");
        }
    }
}
