package cn.edu.nyist.service;

import cn.edu.nyist.model.User;
import org.springframework.stereotype.Service;

/**
 * Description: 用户管理
 * Created by taoyunpeng on 2020/1/17 0017 10:53
 * @author Administrator
 */
public interface IUserService {
    /**
     *
     * @param id
     * @return
     */
    User selectUser(Integer id);
}
