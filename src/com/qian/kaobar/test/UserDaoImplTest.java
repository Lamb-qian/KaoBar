package com.qian.kaobar.test;

import com.qian.kaobar.dao.UserDao;
import com.qian.kaobar.dao.impl.UserDaoImpl;
import com.qian.kaobar.pojo.User;
import org.junit.Test;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-16 21:49
 */
public class UserDaoImplTest {
    UserDao userDao = new UserDaoImpl();
    //User user = new User();

    @Test
    public void saveUserTest(){
        User user = new User(null,"qian", "123456", "18644445555", "BeiJin",null);
        //System.out.println(user.getName());
        //System.out.println(userDao.saveUser(user));
        boolean b = userDao.saveUser(user);
        if(b==true){
            System.out.println("保存用户成功");
        }else {
            System.out.println("保存用户失败");
        }
    }
    @Test
    public void queryByIdTest(){
        System.out.println(userDao.queryById(1));
    }
    @Test
    public void queryByNameTest(){
        System.out.println(userDao.queryByName("qian"));
    }
    @Test
    public void queryByNameAndPasswordTest(){
        System.out.println(userDao.queryByNameAndPassword("lamb","123456"));
    }
}
