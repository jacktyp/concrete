package cn.edu.nyist.service;

import cn.edu.nyist.model.User;

import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2020/2/2 20:01
 * @Created by typ
 */
public interface UserService {
    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    User getUser(Integer id);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUser();
}
