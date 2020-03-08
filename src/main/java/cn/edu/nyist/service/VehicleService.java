package cn.edu.nyist.service;

import cn.edu.nyist.model.Vehicle;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * @ClassName VehicleService
 * @Description 车辆
 * @Date 2020/3/8 9:45
 * @Created by typ
 */
public interface VehicleService {

    /**
     * 通过ID查询
     * @param ids
     * @return
     */
    List<Vehicle> findByIds(List<Integer> ids);

    /**
     * 各种车辆类型
     * @return
     */
    JSONArray findVehicle();

    /**
     * 查询所有
     * @return
     */
    List<Vehicle> findAll();
}
