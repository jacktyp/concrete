package cn.edu.nyist.service;

import cn.edu.nyist.model.Actualpro;
import cn.edu.nyist.model.ConcreteBackList;

import java.util.List;

/**
 * @ClassName ActualproService
 * @Description 实际生产
 * @Date 2020/2/28 13:54
 * @Created by typ
 */
public interface ActualproService {
    /**
     * 当天生产量
     * @return
     */
    Integer dayOfproduction();

    /**
     * 当月生产量 近一个月
     * @return
     */
    Integer monthOfproduction();

    /**
     * 根据开始结束时间查询
     * @param dailyStartTime
     * @param endTime
     * @return
     */
    List<Actualpro> getActualproInDate(Long dailyStartTime, Long endTime);

    /**
     * 查询所有
     * @return
     */
    List<Actualpro> findAll();

    /**
     * 混泥土花费
     * @return
     */
    List<ConcreteBackList> findConcreteCost() throws Exception;

}
