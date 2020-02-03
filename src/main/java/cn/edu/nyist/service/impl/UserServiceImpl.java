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
    public User getUser(Integer id) throws Exception{
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public List<User> findAllUser() throws Exception{
        UserExample userExample = new UserExample();
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public void addUser(User user) throws Exception{
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) throws Exception{
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(user.getId());
        userMapper.updateByExample(user,userExample);
    }

    @Override
    public void deleteUser(Integer id) throws Exception {
        userMapper.deleteByPrimaryKey(id);
    }
}
