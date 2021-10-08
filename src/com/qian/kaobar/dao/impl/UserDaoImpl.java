package com.qian.kaobar.dao.impl;

import com.qian.kaobar.dao.UserDao;
import com.qian.kaobar.pojo.User;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-16 21:32
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryById(Integer id) {
        String sql = "select * from user_tb where id=?";
        return queryForOne(User.class,sql,id);
    }

    @Override
    public User queryByName(String name) {
        String sql = "select * from user_tb where name=?";
        return queryForOne(User.class,sql,name);
    }

    @Override
    public User queryByNameAndPassword(String name, String password) {
        String sql = "select * from user_tb where name=? and password=?";
        return queryForOne(User.class,sql,name,password);
    }

    @Override
    public boolean saveUser(User user) {
        String sql = "insert into user_tb(name,password,tel,address) values(?,?,?,?)";
        return update(sql,user.getName(),user.getPassword(),user.getTel(),user.getAddress());
    }
}
