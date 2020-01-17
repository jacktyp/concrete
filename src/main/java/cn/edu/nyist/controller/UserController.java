package cn.edu.nyist.controller;

import cn.edu.nyist.model.User;
import cn.edu.nyist.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: 用户管理
 * Created by taoyunpeng on 2020/1/17 0017 10:56
 * @author Administrator
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/selectUser")
    @ResponseBody
    public String selectUser(Integer id){
        User user = userService.selectUser(id);
        return user.toString();
    }

}
