package com.qian.kaobar.web;

import com.qian.kaobar.pojo.User;
import com.qian.kaobar.service.UserService;
import com.qian.kaobar.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 14:43
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();
        //调用userService.login()登录处理业务
        User user = userService.login(new User(null, username, password, null, null, null));
        //判断，如果为null登录失败
        if(user == null){
            //把错误信息，和回显的表单项信息，保存到request
            req.setAttribute("msg","用户或密码错误！");
            req.setAttribute("username",username);
            //登录失败
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            //登录成功
            req.getSession().setAttribute("user",user);
            Integer power = user.getPower();
            if(power==0){
                req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
            }
            if(power==1){
                req.getRequestDispatcher("/pages/manager/manager.jsp").forward(req,resp);
            }
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取资源参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String tel = req.getParameter("tel");
        String address = req.getParameter("address");
        boolean existName = userService.existName(username);
        //2.检查用户名是否存在
        if(existName==false){
            boolean b = userService.register(new User(null, username, password, tel, address, null));
            if(b==true){
                req.getRequestDispatcher("/pages/user/register_success.jsp").forward(req,resp);
            }else {
                req.setAttribute("username",username);
                req.getRequestDispatcher("/pages/user/register.jsp").forward(req,resp);
            }
        }else{
            req.setAttribute("msg","用户名已存在");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/register.jsp").forward(req,resp);
        }
    }

    /**
     * 注销账号
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

}
