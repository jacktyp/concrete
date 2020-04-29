package cn.edu.nyist.controller;

import cn.edu.nyist.model.MixproportionDTO;
import cn.edu.nyist.service.MixproportionService;
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
 * @Classname MixproportionController
 * @Description 配合比管理
 * @Date 2020/2/10 10:35
 * @Created by typ
 */
@Controller
@RequestMapping("/concrete/mixproportion")
public class MixproportionController {

    private static final Logger logger = LoggerFactory.getLogger(MixproportionController.class);
    @Autowired
    private MixproportionService mixproportionService;

    /**
     * 查询配合比
     * @return
     */
    @RequestMapping(value = "/selectMixproportion",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil selectMixproportion(Integer limit,Integer page){
        try{
//            if (id == null){
//                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
//            }
            List<MixproportionDTO> mixproportionDTO = mixproportionService.getMixproportion();
            QueryResult<MixproportionDTO> result = QueryUtil.getListByPageInfo(mixproportionDTO, limit, page);
            return LayuiUtil.backLayuiData(result.getItems(),result.getRowCount());
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }


    /**
     * 查询所有配合比
     * @return
     */
    @RequestMapping(value = "/findAllMixproportion",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil findAllMixproportion(Integer limit,Integer page){
        try{
            List<MixproportionDTO> mixproportionDTOList = mixproportionService.findAllMixproportion();
            //分页
            QueryResult<MixproportionDTO> result = QueryUtil.getListByPageInfo(mixproportionDTOList, limit, page);
            return LayuiUtil.backLayuiData(result.getItems(),result.getRowCount());
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.QUERYFAILED));
        }
    }

    /**
     * 增加配合比
     * @return
     */
    @RequestMapping(value = "/addMixproportion",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil addMixproportion(MixproportionDTO mixproportionDTO){
        try{
            mixproportionService.addMixproportion(mixproportionDTO);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.SAVESUCCESS));
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.SAVEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.SAVEFAILED));
        }
    }

    /**
     * 更新配合比
     * @return
     */
    @RequestMapping(value = "/updateMixproportion",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil updateMixproportion(MixproportionDTO mixproportionDTO){
        try{
            if (mixproportionDTO.getId() == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            mixproportionService.updateMixproportion(mixproportionDTO);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.UPDATESUCCESS));
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.UPDATEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.UPDATEFAILED));
        }
    }

    /**
     * 删除配合比
     * @return
     */
    @RequestMapping(value = "/deleteMixproportion",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil deleteMixproportion(Integer id){
        try{
            if (id == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            mixproportionService.deleteMixproportion(id);
            return LayuiUtil.newSuccess(MessageConstant.getMessage(MessageConstant.DELETESUCCESS));
        }catch (Exception e){
            logger.error(MessageConstant.getMessage(MessageConstant.DELETEFAILED));
            return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.DELETEFAILED));
        }
    }
}
