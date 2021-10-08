package com.qian.kaobar.dao;

import com.qian.kaobar.pojo.User;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-16 21:31
 */
public interface UserDao {
    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    User queryById(Integer id);

    /**
     * 根据用户名查询用户信息
     * @param name
     * @return
     */
    User queryByName(String name);

    /**
     * 根据用户名和密码查询用户信息
     * @param name
     * @param password
     * @return
     */
    User queryByNameAndPassword(String name,String password);

    /**
     * 保存用户信息
     * @param user
     * @return true表示保存成那个 false表示保存失败
     */
    boolean saveUser(User user);
}
