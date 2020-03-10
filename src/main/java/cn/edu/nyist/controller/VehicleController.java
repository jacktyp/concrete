package cn.edu.nyist.controller;

import cn.edu.nyist.model.Vehicle;
import cn.edu.nyist.service.VehicleService;
import cn.edu.nyist.util.LayuiUtil;
import cn.edu.nyist.util.MessageConstant;
import cn.edu.nyist.util.QueryResult;
import cn.edu.nyist.util.QueryUtil;
import com.alibaba.fastjson.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


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

    /**
     * 查询车辆
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil findAll(Integer limit, Integer page){
        try{
            List<Vehicle> vehicleList = vehicleService.findAll();
            //分页
            QueryResult<Vehicle> result = QueryUtil.getListByPageInfo(vehicleList, limit, page);
            return LayuiUtil.backLayuiData(result.getItems(),result.getRowCount());
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }

    /**
     * 增加车辆
     * @return
     */
    @RequestMapping(value = "/addVehicle",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil addVehicle(Vehicle vehicle){
        try{
            vehicleService.addScheduleDTO(vehicle);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.SAVESUCCESS));
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.SAVEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.SAVEFAILED));
        }
    }

    /**
     * 删除车辆
     * @return
     */
    @RequestMapping(value = "/deleteVehicle",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil deleteVehicle(Integer id){
        try{
            if (id == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            vehicleService.delete(id);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.DELETESUCCESS));
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.DELETEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.DELETEFAILED));
        }
    }

    /**
     * 更新车辆
     * @return
     */
    @RequestMapping(value = "/updateVehicle",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil updateVehicle(Vehicle vehicle){
        try{
            if (vehicle.getId() == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            vehicleService.update(vehicle);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.UPDATESUCCESS));
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.UPDATEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.UPDATEFAILED));
        }
    }



}
