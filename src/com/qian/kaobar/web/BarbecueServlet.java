package com.qian.kaobar.web;

import com.qian.kaobar.pojo.Barbecue;
import com.qian.kaobar.pojo.Page;
import com.qian.kaobar.service.BarbecueService;
import com.qian.kaobar.service.impl.BarbecueServiceImpl;
import com.qian.kaobar.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 16:03
 */
public class BarbecueServlet extends  BaseServlet {
    private BarbecueService barbecueService = new BarbecueServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(req.getParameter("price")));
        String type = req.getParameter("type");
        String img_path = req.getParameter("img_path");
        boolean b = barbecueService.addBar(new Barbecue(null,name,price,type,img_path));
        if(b==true){
            //添加数据成功返回列表界面
            req.getRequestDispatcher("barbecueServlet?action=queryAll").forward(req,resp);
        }else{
            //添加数据失败返回原来界面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        String name = req.getParameter("name");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(req.getParameter("price")));
        String type = req.getParameter("type");
        String img_path = req.getParameter("img_path");
        boolean b = barbecueService.updateBar(new Barbecue(id, name, price, type, img_path));
        if(b==true){
            //更新数据成功返回列表界面
            req.getRequestDispatcher("barbecueServlet?action=queryAll").forward(req,resp);
        }else{
            //更新数据失败返回原来界面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        boolean b = barbecueService.delBar(id);
        if(b==true){
            resp.sendRedirect(req.getHeader("Referer"));
            //req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }

    protected void getBar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Barbecue barbecue = barbecueService.queryById(id);
        req.setAttribute("barbecue",barbecue);
        req.getRequestDispatcher("/pages/manager/bar_edit.jsp").forward(req,resp);
    }

    protected void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Page<Barbecue> page = barbecueService.page();
        //3 保存page到request域中
        req.setAttribute("page",page);
        //4 请求转发到/pages/manager/bar_manager.jsp中
        req.getRequestDispatcher("/pages/manager/bar_manager.jsp").forward(req,resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 调用bookService.page(),page对象
        Page<Barbecue> page = barbecueService.page();
        //2 保存page到request域中
        req.setAttribute("page",page);
        //3 请求转发到/pages/manager/index.jsp中
        req.getRequestDispatcher("/pages/manager/index.jsp").forward(req,resp);
    }

    protected void sortUpByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Page<Barbecue> page = barbecueService.sortUpByPrice();
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/index.jsp").forward(req,resp);
    }

    protected void sortDownByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Page<Barbecue> page = barbecueService.sortDownByPrice();
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/index.jsp").forward(req,resp);
    }

    protected void queryByType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        Page<Barbecue> page = barbecueService.pageByType(type);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/index.jsp").forward(req,resp);
    }

    protected void queryByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),0);
        Page<Barbecue> page = barbecueService.queryByPrice(min, max);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/index.jsp").forward(req,resp);
    }
}
