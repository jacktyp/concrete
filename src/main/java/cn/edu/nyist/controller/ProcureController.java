package cn.edu.nyist.controller;

import cn.edu.nyist.model.ProcureBackList;
import cn.edu.nyist.model.ProcureMentDTO;
import cn.edu.nyist.model.Procurement;
import cn.edu.nyist.service.ProcureService;
import cn.edu.nyist.util.LayuiUtil;
import cn.edu.nyist.util.MessageConstant;
import cn.edu.nyist.util.QueryResult;
import cn.edu.nyist.util.QueryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
            QueryResult<ProcureBackList> result = QueryUtil.getListByPageInfo(procurementList, limit, page);
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

}
