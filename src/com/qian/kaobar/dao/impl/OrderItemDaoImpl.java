package com.qian.kaobar.dao.impl;

import com.qian.kaobar.dao.OrderItemDao;
import com.qian.kaobar.pojo.OrderItem;

import java.util.List;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 11:26
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public boolean saveOrderItem(OrderItem orderItem) {
        String sql = "insert into order_item_tb(name,count,price,total_price,order_id) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotal_price(),orderItem.getOrder_id());
    }

    @Override
    public List<OrderItem> queryByOrderId(String orderId) {
        String sql = "select id,name,count,price,total_price,order_id from order_item_tb where order_id=?";
        return queryForList(OrderItem.class,sql,orderId);
    }

    @Override
    public List<OrderItem> queryAllOrderItem() {
        String sql = "select id,name,count,price,total_price,order_id from order_item_tb";
        return queryForList(OrderItem.class,sql);
    }
}
