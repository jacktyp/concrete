package cn.edu.nyist.service.impl;

import cn.edu.nyist.dao.IUserDao;
import cn.edu.nyist.model.User;
import cn.edu.nyist.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: 用户管理
 * Created by taoyunpeng on 2020/1/17 0017 10:54
 * @author Administrator
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    /**
     * 用户查询
     * @param id
     * @return
     */
    @Override
    public User selectUser(Integer id) {
        return userDao.selectUser(id);
    }
}
