package com.qian.kaobar.dao.impl;

import com.qian.kaobar.dao.OrderDao;
import com.qian.kaobar.pojo.Order;

import java.util.List;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 11:26
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public boolean saveOrder(Order order) {
        String sql = "insert into order_tb(order_id,create_time,price,user_id) values(?,?,?,?)";
        return update(sql,order.getOrder_id(),order.getCreate_time(),order.getPrice(),order.getUser_id());
    }

    @Override
    public boolean delOrderById(String orderId) {
        String sql = "delete from order_tb where order_id=?";
        return update(sql,orderId);
    }

    @Override
    public boolean updateStatusOrder(Order order) {
        String sql = "update order_tb set status=? where order_id=?";
        return update(sql,order.getStatus(),order.getOrder_id());
    }

    @Override
    public List<Order> queryByUser(int userId) {
        String sql = "select order_id,create_time,price,status,user_id from order_tb where user_id=?";
        return queryForList(Order.class,sql,userId);
    }

    @Override
    public List<Order> queryAllOrder() {
        String sql = "select order_id,create_time,price,status,user_id from order_tb";
        return queryForList(Order.class,sql);
    }
}
