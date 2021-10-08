package com.qian.kaobar.test;

import com.qian.kaobar.dao.OrderItemDao;
import com.qian.kaobar.dao.impl.OrderItemDaoImpl;
import com.qian.kaobar.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 13:13
 */
public class OrderItemDaoImplTest {
    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void addTest(){
        System.out.println(orderItemDao.saveOrderItem(new OrderItem(null, "bar", 10, BigDecimal.valueOf(6), BigDecimal.valueOf(60), "123456")));
    }

    @Test
    public void qTest(){
        System.out.println(orderItemDao.queryByOrderId("123456"));
    }

    @Test
    public void queryTest(){
        System.out.println(orderItemDao.queryAllOrderItem());
    }
}
