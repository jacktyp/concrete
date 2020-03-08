package cn.edu.nyist.controller;

import cn.edu.nyist.model.ConcreteBackList;
import cn.edu.nyist.service.ActualproService;
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
 * @ClassName ActualproController
 * @Description TODO
 * @Date 2020/3/8 16:22
 * @Created by typ
 */
@Controller
@RequestMapping("/concrete/actualpro")
public class ActualproController {

    private static final Logger logger = LoggerFactory.getLogger(ActualproController.class);

    @Autowired
    private ActualproService actualproService;
    /**
     * 车辆费用
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping(value = "/selectConcrete",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil selectConcrete(Integer limit, Integer page){
        try{
            List<ConcreteBackList> concreteBackListList =  actualproService.findConcreteCost();
            QueryResult<ConcreteBackList> result = QueryUtil.getListByPageInfo(concreteBackListList, limit, page);
            return LayuiUtil.backLayuiData(result.getItems(),result.getRowCount());
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }

}
