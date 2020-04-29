package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.UserMapper;
import cn.edu.nyist.model.User;
import cn.edu.nyist.model.UserExample;
import cn.edu.nyist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
        user.setUserState("1");
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) throws Exception{
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(user.getId());
        user.setUserState("0");
        userMapper.updateByExample(user,userExample);
    }

    @Override
    public void deleteUser(Integer id) throws Exception {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User findUser(String userName, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        criteria.andUserPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if (!CollectionUtils.isEmpty(users)){
            return users.get(0);
        }else{
            return null;
        }
    }

}
