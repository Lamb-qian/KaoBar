package com.qian.kaobar.service;

import com.qian.kaobar.pojo.Cart;
import com.qian.kaobar.pojo.Order;
import com.qian.kaobar.pojo.OrderItem;
import com.qian.kaobar.pojo.Page;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 15:25
 */
public interface OrderService {
    /**
     * 保存订单
     * @param cart
     * @param userId
     * @return
     */
    String createOrder(Cart cart, Integer userId);

    /**
     * 删除订单信息
     * @param orderId
     * @return
     */
    boolean delOrderById(String orderId);

    /**
     * 修改物流状态
     * @param order
     * @return
     */
    boolean updateStatusOrder(Order order);

    /**
     * 根据订单编号查询订单
     * @param userId
     * @return
     */
    Page<Order> pageByUser(int userId);

    /**
     * 查询所有订单
     * @return
     */
    Page<Order> pageAllOrder();

    /**
     * 根据订单编号查询订单项
     * @param orderId
     * @return
     */
    Page<OrderItem> pageByOrderId(String orderId);

    /**
     * 查询所有订单项
     * @return
     */
    Page<OrderItem> pageAllOrderItem();
}
