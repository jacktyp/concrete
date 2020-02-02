package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.UserMapper;
import cn.edu.nyist.model.User;
import cn.edu.nyist.model.UserExample;
import cn.edu.nyist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2020/2/2 20:05
 * @Created by typ
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public List<User> findAllUser() {
        UserExample userExample = new UserExample();
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }
}
