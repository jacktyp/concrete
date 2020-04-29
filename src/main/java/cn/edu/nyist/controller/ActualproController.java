package cn.edu.nyist.controller;

import cn.edu.nyist.model.ActualproDTO;
import cn.edu.nyist.model.ConcreteBackList;
import cn.edu.nyist.service.ActualproService;
import cn.edu.nyist.util.LayuiUtil;
import cn.edu.nyist.util.MessageConstant;
import cn.edu.nyist.util.QueryResult;
import cn.edu.nyist.util.QueryUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
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
     * 混凝土收入
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping(value = "/selectConcrete",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil selectConcrete(Integer limit, Integer page){
        try{
            List<ConcreteBackList> concreteBackListList =  actualproService.findConcreteCost();
            List<String> listData = Lists.newArrayList();
            List<String> listPrice = Lists.newArrayList();

            for (ConcreteBackList concreteBackList : concreteBackListList) {
                String date = concreteBackList.getDate();
                String price = concreteBackList.getPrice();
                listData.add(date);
                listPrice.add(price);
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("listData",listData);
            jsonObject.put("listPrice",listPrice);
            //QueryResult<ConcreteBackList> result = QueryUtil.getListByPageInfo(concreteBackListList, limit, page);
            //return LayuiUtil.backLayuiData(result.getItems(),result.getRowCount());
            return LayuiUtil.newSuccess(JSONObject.toJSONString(jsonObject));
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }
    /**
     * 查询所有实际生产
     * @return
     */
    @RequestMapping(value = "/findAllActualpro",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil findAllActualpro(Integer limit, Integer page){
        try{
            List<ActualproDTO> actualproDTOList = actualproService.findAllActualpro();
            //分页
            QueryResult<ActualproDTO> result = QueryUtil.getListByPageInfo(actualproDTOList, limit, page);
            return LayuiUtil.backLayuiData(result.getItems(),result.getRowCount());
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }


    /**
     * 增加实际生产
     * @return
     */

    @RequestMapping(value = "/addActualproDTO",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil addActualproDTO(ActualproDTO actualproDTO){
        try{
            actualproService.addActualproDTO(actualproDTO);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.SAVESUCCESS));
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.SAVEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.SAVEFAILED));
        }
    }

/**
     * 删除实际生产
     * @return
     */

    @RequestMapping(value = "/deleteActualproDTO",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil deleteActualproDTO(Integer id){
        try{
            if (id == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            actualproService.delete(id);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.DELETESUCCESS));
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.DELETEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.DELETEFAILED));
        }
    }

/**
     * 更新实际生产
     * @return
     */

    @RequestMapping(value = "/updateActualproDTO",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil updateActualproDTO(ActualproDTO actualproDTO){
        try{
            if (actualproDTO.getId() == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            actualproService.update(actualproDTO);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.UPDATESUCCESS));
        }catch (Exception e){
            //logger.error(MessageConstant.getMessage(MessageConstant.UPDATEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.UPDATEFAILED));
        }
    }
}
