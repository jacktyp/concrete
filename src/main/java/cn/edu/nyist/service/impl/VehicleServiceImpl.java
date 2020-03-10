package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.VehicleMapper;
import cn.edu.nyist.model.Vehicle;
import cn.edu.nyist.model.VehicleExample;
import cn.edu.nyist.service.VehicleService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName VehicleServiceImpl
 * @Description TODO
 * @Date 2020/3/8 9:55
 * @Created by typ
 */
@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    public List<Vehicle> findByIds(List<Integer> ids) {
        VehicleExample vehicleExample = new VehicleExample();
        VehicleExample.Criteria criteria = vehicleExample.createCriteria();
        criteria.andIdIn(ids);
        List<Vehicle> vehicleList = vehicleMapper.selectByExample(vehicleExample);
        return vehicleList;
    }

    @Override
    public JSONArray findVehicle() {
        List<Vehicle> vehicleList = vehicleMapper.selectByExample(new VehicleExample());
        String state = "1";
        Map<String, Long> typeCountMap = vehicleList.stream()
                .filter(p -> state.equals(p.getState()))
                .collect(Collectors.groupingBy(Vehicle::getType, Collectors.counting()));
        JSONArray jsonArray = new JSONArray();
        for (Map.Entry<String, Long> entry : typeCountMap.entrySet()){
            String type = entry.getKey();
            Long count = entry.getValue();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("vehicleName",type);
            jsonObject.put("vehicleCount",count);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleMapper.selectByExample(new VehicleExample());
    }

    @Override
    public void addScheduleDTO(Vehicle vehicle) {
        vehicleMapper.insert(vehicle);
    }

    @Override
    public void delete(Integer id) {
        vehicleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Vehicle vehicle) {
        vehicleMapper.updateByPrimaryKey(vehicle);
    }
}
