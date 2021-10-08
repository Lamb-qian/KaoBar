package com.qian.kaobar.service;

import com.qian.kaobar.pojo.User;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 14:39
 */
public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean register(User user);

    /**
     * 用登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 检查用户名是否存在
     * @param name
     * @return false表示不存在，true表示存在
     */
    boolean existName(String name);
}
