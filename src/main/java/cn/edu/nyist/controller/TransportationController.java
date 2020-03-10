package cn.edu.nyist.controller;

import cn.edu.nyist.model.TransportationBackList;
import cn.edu.nyist.model.TransportationDTO;
import cn.edu.nyist.service.TransportationService;
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
 * @ClassName TransportationController
 * @Description TODO
 * @Date 2020/3/8 15:13
 * @Created by typ
 */
@Controller
@RequestMapping("/concrete/transportation")
public class TransportationController {
    private static final Logger logger = LoggerFactory.getLogger(MaterialController.class);

    @Autowired
    private TransportationService transportationService;

    /**
     * 车辆费用
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping(value = "/selectTransport",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil selectTransport(Integer limit,Integer page){
        try{
            List<TransportationBackList> transportationDTOList =  transportationService.findVehicleCost();
            QueryResult<TransportationBackList> result = QueryUtil.getListByPageInfo(transportationDTOList, limit, page);
            return LayuiUtil.backLayuiData(result.getItems(),result.getRowCount());
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }

    /**
     * 查询所有运输单
     * @return
     */
    @RequestMapping(value = "/findAllTransport",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil findAllTransport(Integer limit, Integer page){
        try{
            List<TransportationDTO> transportDTOList = transportationService.findAllTransport();
            //分页
            QueryResult<TransportationDTO> result = QueryUtil.getListByPageInfo(transportDTOList, limit, page);
            return LayuiUtil.backLayuiData(result.getItems(),result.getRowCount());
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }

    /**
     * 增加运输单
     * @return
     */
    @RequestMapping(value = "/addTransportDTO",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil addTransportDTO(TransportationDTO transportationDTO){
        try{
            transportationService.addTransportDTO(transportationDTO);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.SAVESUCCESS));
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.SAVEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.SAVEFAILED));
        }
    }

    /**
     * 删除运输单
     * @return
     */
    @RequestMapping(value = "/deleteTransportDTO",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil deleteTransportDTO(Integer id){
        try{
            if (id == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            transportationService.delete(id);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.DELETESUCCESS));
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.DELETEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.DELETEFAILED));
        }
    }

    /**
     * 更新运输单
     * @return
     */
    @RequestMapping(value = "/updateTransportDTO",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil updateTransportDTO(TransportationDTO transportationDTO){
        try{
            if (transportationDTO.getId() == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            transportationService.update(transportationDTO);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.UPDATESUCCESS));
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.UPDATEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.UPDATEFAILED));
        }
    }


}
