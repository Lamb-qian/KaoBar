package com.qian.kaobar.test;

import com.qian.kaobar.dao.OrderDao;
import com.qian.kaobar.dao.impl.OrderDaoImpl;
import com.qian.kaobar.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 12:42
 */
public class OrderDaoImplTest {
    OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void addTest(){
        System.out.println(orderDao.saveOrder(new Order("123456", new Date(), BigDecimal.valueOf(100),null)));
    }
    @Test
    public void delTest(){
        System.out.println(orderDao.delOrderById("123456"));
    }
    @Test
    public void updateStatusTest(){
        System.out.println(orderDao.updateStatusOrder(new Order("123456", 1)));
    }
    @Test
    public void queryTest(){
        //System.out.println(orderDao.queryByUser());
        System.out.println(orderDao.queryAllOrder());
    }
}
