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
    User getUser(Integer id) throws Exception;

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUser() throws Exception;

    /**
     * 增加用户
     * @param user
     */
    void addUser(User user) throws Exception;

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user) throws Exception;

    /**
     * 删除用户
     * @param id
     * @throws Exception
     */
    void deleteUser(Integer id) throws Exception;

    User findUser(String userName, String password);

}
