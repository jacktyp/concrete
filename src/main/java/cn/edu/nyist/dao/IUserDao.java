package cn.edu.nyist.dao;

import cn.edu.nyist.model.User;
import org.springframework.stereotype.Repository;

/**
 * Description: 用户管理
 * Created by taoyunpeng on 2020/1/17 0017 10:48
 * @author Administrator
 */
public interface IUserDao {
    /**
     * 查询用户信息
     * @param id 用户ID
     * @return
     */
    User selectUser(Integer id);
}
