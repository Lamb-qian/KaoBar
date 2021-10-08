package com.qian.kaobar.web;

import com.google.gson.Gson;
import com.qian.kaobar.pojo.Barbecue;
import com.qian.kaobar.pojo.Cart;
import com.qian.kaobar.pojo.CartItem;
import com.qian.kaobar.service.BarbecueService;
import com.qian.kaobar.service.impl.BarbecueServiceImpl;
import com.qian.kaobar.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-16 14:01
 */
public class CartServlet extends BaseServlet{

    private BarbecueService barbecueService = new BarbecueServiceImpl();
    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        // 调用queryBar得到信息
        Barbecue barbecue = barbecueService.queryById(id);
        //把图书信息转换为商品项
        CartItem cartItem = new CartItem(barbecue.getId(),barbecue.getName(),1,barbecue.getPrice(),barbecue.getPrice());
        //调用cart.addItem添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        //重定向回原来商品所在的地址列表页面
        resp.sendRedirect(req.getHeader("Referer"));
        //最后添加的商品名称
        req.getSession().setAttribute("lastName",cartItem.getName());
    }

    /**
     * 删除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null){
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Integer count = Integer.parseInt(req.getParameter("count"));
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        // 调用queryBar得到信息
        Barbecue barbecue = barbecueService.queryById(id);
        //把信息转换为商品项
        CartItem cartItem = new CartItem(barbecue.getId(),barbecue.getName(),1,barbecue.getPrice(),barbecue.getPrice());
        //调用cart.addItem添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName", cartItem.getName());

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);

        resp.getWriter().write(resultMapJsonString);
    }
}
