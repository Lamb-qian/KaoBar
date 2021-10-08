package com.qian.kaobar.test;

import com.qian.kaobar.pojo.User;
import com.qian.kaobar.service.UserService;
import com.qian.kaobar.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 15:45
 */
public class UserServiceTest {
    UserService service = new UserServiceImpl();

    @Test
    public void existTest(){
        System.out.println(service.existName("qian"));
    }

    @Test
    public void loginTest(){
        System.out.println(service.login(new User(null,"admin","admin",null,null,null)));
    }

    @Test
    public void registerTest(){
        System.out.println(service.register(new User(null, "qian", "123456", "123654789", "guizhou", null)));
    }
}
