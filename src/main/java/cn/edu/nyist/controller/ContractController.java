package cn.edu.nyist.controller;

import cn.edu.nyist.model.ContractDTO;
import cn.edu.nyist.service.ContractService;
import cn.edu.nyist.util.LayuiUtil;
import cn.edu.nyist.util.MessageConstant;
import cn.edu.nyist.util.QueryResult;
import cn.edu.nyist.util.QueryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Classname ContractController
 * @Description 合同管理
 * @Date 2020/2/10 9:04
 * @Created by typ
 */
@Controller
@RequestMapping("/concrete/contract")
public class ContractController {
    private static final Logger logger = LoggerFactory.getLogger(ContractController.class);

    @Autowired
    private ContractService contractService;

    /**
     * 查询合同
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectContract",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil selectContract(Integer id){
        try{
            if (id == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            ContractDTO contractDTO = contractService.getContract(id);
            return LayuiUtil.newSuccess(contractDTO.toString());
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }

    /**
     * 查询为0的合同
     * @return
     */
    @RequestMapping(value = "/findAllContractByState",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil findAllContractByState(Integer limit,Integer page){
        try{
            List<ContractDTO> contractList = contractService.findAllContractByState();
            //分页
            QueryResult<ContractDTO> result = QueryUtil.getListByPageInfo(contractList, limit, page);
            System.out.print(LayuiUtil.backLayuiData(result.getItems(),result.getRowCount()));
            return LayuiUtil.backLayuiData(result.getItems(),result.getRowCount());
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }

    /**
     * 查询所有合同
     * @return
     */
    @RequestMapping(value = "/findAllContract",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil findAllContract(Integer limit,Integer page){
        try{
            List<ContractDTO> contractList = contractService.findAllContract();
            //分页
            QueryResult<ContractDTO> result = QueryUtil.getListByPageInfo(contractList, limit, page);
            return LayuiUtil.backLayuiData(result.getItems(),result.getRowCount());
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }

    /**
     * 增加合同
     * @return
     */
    @RequestMapping(value = "/addContract",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil addContract(ContractDTO contract){
        try{
            contract.setRemark("0");
            contractService.addContract(contract);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.SAVESUCCESS));
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.SAVEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.SAVEFAILED));
        }
    }

    /**
     * 更新合同
     * @return
     */
    @RequestMapping(value = "/updateContract",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil updateContract(ContractDTO contractDTO){
        try{
            if (contractDTO.getId() == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            contractService.updateContract(contractDTO);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.UPDATESUCCESS));
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.UPDATEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.UPDATEFAILED));
        }
    }

    /**
     * 删除合同
     * @return
     */
    @RequestMapping(value = "/deleteContract",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil deleteContract(Integer id){
        try{
            if (id == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            contractService.deleteContract(id);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.DELETESUCCESS));
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.DELETEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.DELETEFAILED));
        }
    }

}
