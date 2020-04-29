package cn.edu.nyist.controller;

import cn.edu.nyist.model.User;
import cn.edu.nyist.service.UserService;
import cn.edu.nyist.util.LayuiUtil;
import cn.edu.nyist.util.MessageConstant;
import cn.edu.nyist.util.QueryResult;
import cn.edu.nyist.util.QueryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/concrete/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/selectUser",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil selectUser(Integer id){
        try{
            if (id == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            User user = userService.getUser(id);
            return LayuiUtil.newSuccess(user.toString());
        }catch (Exception e){
            logger.error("查询失败");
            return LayuiUtil.newFaild("查询失败");
        }
    }


    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "/findAllUser",method = RequestMethod.GET)
    @ResponseBody
    public LayuiUtil findAllUser(Integer limit,Integer page){
        try{
            List<User> userList = userService.findAllUser();
            //分页
            QueryResult<User> result = QueryUtil.getListByPageInfo(userList, limit, page);
            return LayuiUtil.backLayuiData(result.getItems(),result.getRowCount());
        }catch (Exception e){
            logger.error("查询失败");
            return LayuiUtil.newFaild("查询失败");
        }
    }

    /**
     * 增加用户
     * @return
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil addUser(User user){
        try{
            userService.addUser(user);
            return LayuiUtil.newSuccess("插入成功");
        }catch (Exception e){
            logger.error("插入失败");
            return LayuiUtil.newFaild("插入失败");
        }
    }

    /**
     * 更新用户
     * @return
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil updateUser(User user){
        try{
            if (user.getId() == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            userService.updateUser(user);
            return LayuiUtil.newSuccess("更新成功");
        }catch (Exception e){
            logger.error("更新失败");
            return LayuiUtil.newFaild("更新失败");
        }
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil deleteUser(Integer id){
        try{
            if (id == null){
                return LayuiUtil.newFaild(MessageConstant.getMessage(MessageConstant.PARAMSMISS1,"id"));
            }
            userService.deleteUser(id);
            return LayuiUtil.newSuccess("删除成功");
        }catch (Exception e){
            logger.error("删除失败");
            return LayuiUtil.newFaild("删除失败");
        }
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/backPageByState",method = RequestMethod.GET)
    //@ResponseBody
    public String backPageByState(Integer state,String userName,String password){
            User user = userService.findUser(userName,password);
            if (user != null){
                if ("1".equals(state)){
                    return "Functionalpage";
                } else if ("2".equals(state)) {
                    return "Functionalpage1";
                }else if ("3".equals(state)) {
                    return "Functionalpage2";
                }else if ("4".equals(state)) {
                    return "Functionalpage3";
                }else if ("5".equals(state)) {
                    return "Functionalpage4";
                }
            }
        return "loginFail";
    }

    //登录验证
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public LayuiUtil login(String userName,String userPassword){
            User user = userService.findUser(userName,userPassword);
            if (user != null){
                if ("1".equals(user.getUserType())){
                    return LayuiUtil.newSuccess("1");
                }else if("2".equals(user.getUserType())){
                    return LayuiUtil.newSuccess("2");
                }else if("3".equals(user.getUserType())){
                    return LayuiUtil.newSuccess("3");
                }else if("4".equals(user.getUserType())){
                    return LayuiUtil.newSuccess("4");
                }else{
                    return LayuiUtil.newFaild("登录失败");
                }
            }else{
                return LayuiUtil.newFaild("登录失败");
            }
    }


}
