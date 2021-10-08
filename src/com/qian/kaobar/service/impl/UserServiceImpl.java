package com.qian.kaobar.service.impl;

import com.qian.kaobar.dao.UserDao;
import com.qian.kaobar.dao.impl.UserDaoImpl;
import com.qian.kaobar.pojo.User;
import com.qian.kaobar.service.UserService;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 14:48
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public boolean register(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryByNameAndPassword(user.getName(),user.getPassword());
    }

    @Override
    public boolean existName(String name) {
        User user = userDao.queryByName(name);
        if(user==null){
            return false;
        }else {
            return true;
        }
    }
}
