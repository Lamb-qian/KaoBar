package com.qian.kaobar.filter;

import com.qian.kaobar.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-16 20:43
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();//提交事务
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();//回滚事务
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给Tomcat统一展示
        }
    }

    @Override
    public void destroy() {

    }
}
