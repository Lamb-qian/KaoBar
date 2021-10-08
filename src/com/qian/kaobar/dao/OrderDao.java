package com.qian.kaobar.dao;

import com.qian.kaobar.pojo.Order;

import java.util.List;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 10:51
 */
public interface OrderDao {
    /**
     * 保存订单
     * @param order
     * @return
     */
    boolean saveOrder(Order order);

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
    List<Order> queryByUser(int userId);

    /**
     * 查询所有订单
     * @return
     */
    List<Order> queryAllOrder();
}
