package com.qian.kaobar.dao.impl;

import com.qian.kaobar.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-16 21:32
 */
public abstract class BaseDao {
    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update() 方法用来执行：Insert\Update\Delete语句
     * @return 返回false表示执行失败，<br/>返回true表示成功
     */
    public boolean update(String sql,Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            int i = queryRunner.update(conn,sql,args);
            if(i>0){
                JdbcUtils.commitAndClose();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     *查询返回一个JavaBean的sql语句
     * @param type  返回的对象类型
     * @param sql   执行的SQL语句
     * @param args  sql对应的参数值
     * @param <T>   返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql,Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     *查询返回多个JavaBean的sql语句
     * @param type  返回的对象类型
     * @param sql   执行的SQL语句
     * @param args  sql对应的参数值
     * @param <T>   返回的类型的泛型
     * @return
     */
    public <T>List<T> queryForList(Class<T> type,String sql,Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql   执行的sql
     * @param args  执行对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql,Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
