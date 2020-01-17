package cn.edu.nyist.controller;

import cn.edu.nyist.model.User;
import cn.edu.nyist.service.IUserService;
import cn.edu.nyist.util.MessageConstant;
import cn.edu.nyist.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static cn.edu.nyist.util.MessageConstant.PARAMSMISS1;

/**
 * Description: 用户管理
 * Created by taoyunpeng on 2020/1/17 0017 10:56
 * @author Administrator
 */
@Controller
@RequestMapping("/concrete/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    /**
     * 查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectUser",method = RequestMethod.GET)
    @ResponseBody
    public Result<String> selectUser(Integer id){
        try{
            if (id == null){
                return Result.newFaild(MessageConstant.getMessage(PARAMSMISS1,"id"));
            }
            User user = userService.selectUser(id);
            return Result.newSuccess(user.toString());
        }catch (Exception e){
            logger.error("查询失败");
            return Result.newFaild("查询失败");
        }
    }

}
