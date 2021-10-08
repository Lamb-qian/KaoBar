package com.qian.kaobar.dao;

import com.qian.kaobar.pojo.OrderItem;

import java.util.List;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 10:51
 */
public interface OrderItemDao {
    /**
     * 保存订单项
     * @param orderItem
     * @return
     */
    boolean saveOrderItem(OrderItem orderItem);

    /**
     * 根据订单编号查询订单项
     * @param orderId
     * @return
     */
    List<OrderItem> queryByOrderId(String orderId);

    /**
     * 查询所有订单项
     * @return
     */
    List<OrderItem> queryAllOrderItem();
}
