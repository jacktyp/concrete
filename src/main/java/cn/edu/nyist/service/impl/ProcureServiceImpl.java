package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.ProcurementMapper;
import cn.edu.nyist.model.ProcureBackList;
import cn.edu.nyist.model.ProcureMentDTO;
import cn.edu.nyist.model.Procurement;
import cn.edu.nyist.model.ProcurementExample;
import cn.edu.nyist.service.ProcureService;
import cn.edu.nyist.util.DateUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName ProcureServiceImpl
 * @Description TODO
 * @Date 2020/3/8 9:48
 * @Created by typ
 */
@Service
public class ProcureServiceImpl implements ProcureService {
    @Autowired
    private ProcurementMapper procurementMapper;
    @Override
    public List<Procurement> findProcureInDate(Long startTime, Long endTime) {
        ProcurementExample procurementExample = new ProcurementExample();
        ProcurementExample.Criteria criteria = procurementExample.createCriteria();
        criteria.andTimeGreaterThanOrEqualTo(startTime);
        criteria.andTimeLessThanOrEqualTo(endTime);
        List<Procurement> procurementList = procurementMapper.selectByExample(procurementExample);
        return procurementList;
    }

    @Override
    public List<ProcureBackList> findProcureList() {
        List<Procurement> procurementList = procurementMapper.selectByExample(new ProcurementExample());
        //转换的集合
        List<ProcureMentDTO> procureMentDTOList = Lists.newArrayList();
        procurementList.forEach(p->procureMentDTOList.add(new ProcureMentDTO().transfer(p)));
        List<ProcureBackList> procureBackListList = Lists.newArrayList();
        //按时间 类型分组
        Map<String, Map<String, List<ProcureMentDTO>>> timeTypeMap = procureMentDTOList.stream()
                .collect(Collectors.groupingBy(ProcureMentDTO::getTime, Collectors.groupingBy(ProcureMentDTO::getType)));
        for (Map.Entry<String, Map<String, List<ProcureMentDTO>>> entry : timeTypeMap.entrySet()){
            String time = entry.getKey();
            Map<String, List<ProcureMentDTO>> typeMap = entry.getValue();
            //遍历每一个类型
            for (Map.Entry<String, List<ProcureMentDTO>> typeEntry : typeMap.entrySet()){
                String type = typeEntry.getKey();
                List<ProcureMentDTO> procureMentDTOS = typeEntry.getValue();
                Double price = procureMentDTOS.stream().collect(Collectors.summingDouble(ProcureMentDTO::getPriceamount));
                ProcureBackList procureBackList = new ProcureBackList();
                procureBackList.setDate(time);
                procureBackList.setState(type);
                procureBackList.setPrice(price);
                procureBackListList.add(procureBackList);
            }
        }
        return procureBackListList;
    }

    @Override
    public void addProcureDTO(ProcureMentDTO procureMentDTO) {
        Procurement procurement = new ProcureMentDTO().transferBack(procureMentDTO);
        procurementMapper.insert(procurement);
    }

    @Override
    public void delete(Integer id) {
        procurementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ProcureMentDTO procureMentDTO) {
        Procurement procurement = new ProcureMentDTO().transferBack(procureMentDTO);
        procurementMapper.updateByPrimaryKey(procurement);
    }

}
