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


}
