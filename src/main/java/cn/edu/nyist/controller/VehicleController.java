package cn.edu.nyist.controller;

import cn.edu.nyist.service.VehicleService;
import cn.edu.nyist.util.LayuiUtil;
import cn.edu.nyist.util.MessageConstant;
import com.alibaba.fastjson.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @ClassName VehicleController
 * @Description TODO
 * @Date 2020/3/8 12:55
 * @Created by typ
 */
@Controller
@RequestMapping("/concrete/vehicle")
public class VehicleController {
    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    private VehicleService vehicleService;
    /**
     * 车辆统计表中计算各种类型车辆的和，state=1的计算
     * @return
     */
    @RequestMapping(value = "/selectVehicle",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil selectVehicle(){
        try{
            JSONArray vehicles = vehicleService.findVehicle();
            return LayuiUtil.newSuccess(vehicles.toString());
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }


}
