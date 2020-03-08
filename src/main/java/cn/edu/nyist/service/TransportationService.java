package cn.edu.nyist.service;

import cn.edu.nyist.model.Transportation;
import cn.edu.nyist.model.TransportationBackList;
import cn.edu.nyist.model.TransportationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TransportationService
 * @Description 运输
 * @Date 2020/3/8 9:44
 * @Created by typ
 */
public interface TransportationService {

    /**
     * 根据时间查询
     * @param startTime
     * @param endTime
     * @return
     */
    List<Transportation> findTransportationInDate(Long startTime, Long endTime);

    /**
     * 车辆费用
     * @return
     */
    List<TransportationBackList> findVehicleCost();
}
