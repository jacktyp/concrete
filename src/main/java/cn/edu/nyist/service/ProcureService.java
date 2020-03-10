package cn.edu.nyist.service;

import cn.edu.nyist.model.ProcureBackList;
import cn.edu.nyist.model.ProcureMentDTO;
import cn.edu.nyist.model.Procurement;

import java.util.List;

/**
 * @ClassName ProcureService
 * @Description 原材料
 * @Date 2020/3/8 9:44
 * @Created by typ
 */
public interface ProcureService {
    /**
     * 根据时间查询
     * @param startTime
     * @param endTime
     * @return
     */
    List<Procurement> findProcureInDate(Long startTime, Long endTime);

    /**
     * 原材料的费用支出
     * @return
     */
    List<ProcureBackList> findProcureList();

    void addProcureDTO(ProcureMentDTO procureMentDTO);

    void delete(Integer id);

    void update(ProcureMentDTO procureMentDTO);
}
