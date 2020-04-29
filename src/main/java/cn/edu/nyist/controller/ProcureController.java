package cn.edu.nyist.controller;

import cn.edu.nyist.model.ProcureBackList;
import cn.edu.nyist.model.ProcureMentDTO;
import cn.edu.nyist.model.Procurement;
import cn.edu.nyist.service.ProcureService;
import cn.edu.nyist.util.LayuiUtil;
import cn.edu.nyist.util.MessageConstant;
import cn.edu.nyist.util.QueryResult;
import cn.edu.nyist.util.QueryUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName ProcureController
 * @Description 采购
 * @Date 2020/3/8 13:09
 * @Created by typ
 */
@Controller
@RequestMapping("/concrete/procure")
public class ProcureController {
    private static final Logger logger = LoggerFactory.getLogger(ProcureController.class);

    @Autowired
    private ProcureService procureService;

    /**
     * 原材料的费用支出
     */
    @RequestMapping(value = "/selectProcure",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil selectProcure(Integer limit,Integer page){
        try{
            List<ProcureBackList> procurementList = procureService.findProcureList();
            Map<String, List<ProcureBackList>> stringListMap = procurementList.stream().collect(Collectors.groupingBy(ProcureBackList::getDate));
            int size = stringListMap.size();
            List<String> listData = new ArrayList<>(size);
            List<Double> listState1 = new ArrayList<>(size);
            List<Double> listState2 = new ArrayList<>(size);
            List<Double> listState3 = new ArrayList<>(size);
            List<Double> listState4 = new ArrayList<>(size);
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i < size; i++) {
                listState1.add(0.0);
                listState2.add(0.0);
                listState3.add(0.0);
                listState4.add(0.0);
            }

            int count = 0;
            for (Map.Entry<String,List<ProcureBackList>> entry : stringListMap.entrySet()){

                String key = entry.getKey();
                listData.add(key);

                List<ProcureBackList> value = entry.getValue();
                if (!CollectionUtils.isEmpty(value)){
                    for (ProcureBackList procureBackList : value) {
                        String state = procureBackList.getState();
                        Double price = procureBackList.getPrice();
                        if ("1".equals(state)){
                            listState1.set(count,price);
                        }else if ("2".equals(state)){
                            listState2.set(count,price);
                        }else if ("3".equals(state)){
                            listState3.set(count,price);
                        }else if ("4".equals(state)){
                            listState4.set(count,price);
                        }
                    }
                }
                count++;

            }

            jsonObject.put("listData",listData);
            jsonObject.put("listState1",listState1);
            jsonObject.put("listState2",listState2);
            jsonObject.put("listState3",listState3);
            jsonObject.put("listState4",listState4);

//            QueryResult<ProcureBackList> result = QueryUtil.getListByPageInfo(procurementList, limit, page);
            return LayuiUtil.newSuccess(JSON.toJSONString(jsonObject));
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }

    /**
     * 查询所有采购
     * @return
     */
    @RequestMapping(value = "/findAllProcure",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil findAllProcure(Integer limit,Integer page){
        try{
            List<ProcureMentDTO> contractList = procureService.findAllContract();
            //分页
            QueryResult<ProcureMentDTO> result = QueryUtil.getListByPageInfo(contractList, limit, page);
            return LayuiUtil.backLayuiData(result.getItems(),result.getRowCount());
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }

    /**
     * 增加采购
     * @return
     */
    @RequestMapping(value = "/addProcureDTO",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil addProcureDTO(ProcureMentDTO procureMentDTO){
        try{
            procureService.addProcureDTO(procureMentDTO);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.SAVESUCCESS));
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.SAVEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.SAVEFAILED));
        }
    }
    /**
     * 删除采购
     * @return
     */
    @RequestMapping(value = "/deleteProcureDTO",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil deleteProcureDTO(Integer id){
        try{
            if (id == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            procureService.delete(id);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.DELETESUCCESS));
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.DELETEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.DELETEFAILED));
        }
    }

    /**
     * 更新采购
     * @return
     */
    @RequestMapping(value = "/updateProcureDTO",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil updateProcureDTO(ProcureMentDTO procureMentDTO){
        try{
            if (procureMentDTO.getId() == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            procureService.update(procureMentDTO);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.UPDATESUCCESS));
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.UPDATEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.UPDATEFAILED));
        }
    }

    public static void main(String[] args) {
        List<Double> listData = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            listData.add(0.0);
        }
        System.out.println(listData.get(0));
        listData.forEach(p-> System.out.println(p));
        for (int i = 0; i < 10; i++) {
            listData.set(i,Double.parseDouble(i+""));
        }


        listData.forEach(p-> System.out.println(p));
    }

}
