package com.qian.kaobar.web;

import com.qian.kaobar.pojo.Cart;
import com.qian.kaobar.pojo.Order;
import com.qian.kaobar.pojo.OrderItem;
import com.qian.kaobar.pojo.Page;
import com.qian.kaobar.service.OrderService;
import com.qian.kaobar.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-19 20:32
 */
public class OrderServlet extends BaseServlet {
    OrderService orderService = new OrderServiceImpl();

    /**
     * 用户结账时产生订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        int id = Integer.parseInt(req.getParameter("id"));
        String orderId = orderService.createOrder(cart, id);
        req.setAttribute("orderId",orderId);
        req.getRequestDispatcher("pages/cart/checkout.jsp").forward(req,resp);
    }

    /**
     * 查询我的订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void myOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Page<Order> page = orderService.pageByUser(id);
        req.setAttribute("page",page);
        req.getRequestDispatcher("pages/order/my_order.jsp").forward(req,resp);
    }

    /**
     * 查看我的订单项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void myOrderItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        Page<OrderItem> itemPage = orderService.pageByOrderId(orderId);
        req.setAttribute("itemPage",itemPage);
        req.getRequestDispatcher("pages/order/my_orderItem.jsp").forward(req,resp);
    }

    /**
     * 订单管理
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void orderManager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Page<Order> page = orderService.pageAllOrder();
        req.setAttribute("page",page);
        req.getRequestDispatcher("pages/order/order_manager.jsp").forward(req,resp);
    }

    /**
     * 修改订单状态
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateStatus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        int status = Integer.parseInt(req.getParameter("status"));
        boolean b = orderService.updateStatusOrder(new Order(orderId,status+1));
        if(b == true){
            resp.sendRedirect(req.getHeader("Referer"));
        }else {
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
