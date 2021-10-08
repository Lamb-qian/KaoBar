package com.qian.kaobar.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-16 20:43
 */
public class JdbcUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static{
        try {
            Properties properties = new Properties();
            //读取jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接池中的连接
     * @return 返回null则获取失败，反之
     */
    public static Connection getConnection(){
        Connection conn = conns.get();

        if(conn == null){
            try {
                //从数据库连接池中获取连接
                conn = dataSource.getConnection();
                //保存到ThreadLocal对象中，共后面jdbc操作使用
                conns.set(conn);
                //设置手动管理事务
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        Connection conn = conns.get();
        if(conn != null){
            try {
                conn.commit();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    conn.close();//关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，否则就会出错(因为tomcat服务器底层使用了线程池技术)
        conns.remove();
    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection conn = conns.get();
        if(conn != null){
            try {
                conn.rollback();//回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    conn.close();//关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，否则就会出错(因为tomcat服务器底层使用了线程池技术)
        conns.remove();
    }

    /**
     * 关闭连接，放回数据库连接池
     * @param conn

    public static void close(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
     */
}
