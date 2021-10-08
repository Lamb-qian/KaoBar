package com.qian.kaobar.dao.impl;

import com.qian.kaobar.dao.BarbecueDao;
import com.qian.kaobar.pojo.Barbecue;

import java.util.List;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 9:58
 */
public class BarbecueDaoImpl extends BaseDao implements BarbecueDao {
    @Override
    public boolean addBar(Barbecue bar) {
        String sql = "insert into barbecue_tb(name,price,type,img_path) values(?,?,?,?)";
        return update(sql,bar.getName(),bar.getPrice(),bar.getType(),bar.getImg_path());
    }

    @Override
    public boolean delBar(Integer id) {
        String sql = "delete from barbecue_tb where id=?";
        return update(sql,id);
    }

    @Override
    public boolean updateBar(Barbecue bar) {
        String sql = "update barbecue_tb set name=?,price=?,type=?,img_path=? where id=?";
        return update(sql,bar.getName(),bar.getPrice(),bar.getType(),bar.getImg_path(),bar.getId());
    }

    @Override
    public Barbecue queryById(Integer id) {
        String sql = "select id,name,price,type,img_path from barbecue_tb where id=?";
        return queryForOne(Barbecue.class,sql,id);
    }

    @Override
    public List<Barbecue> queryAllBar() {
        String sql ="select id,name,price,type,img_path from barbecue_tb";
        return queryForList(Barbecue.class,sql);
    }

    @Override
    public List<Barbecue> queryByPrice(int min, int max) {
        String sql = "select id,name,price,type,img_path from barbecue_tb where price between ? and ? order by price acs";
        return queryForList(Barbecue.class,sql,min,max);
    }

    @Override
    public List<Barbecue> sortUpByPrice() {
        String sql = "select id,name,price,type,img_path from barbecue_tb order by price asc";
        return queryForList(Barbecue.class,sql);
    }

    @Override
    public List<Barbecue> sortDownByPrice() {
        String sql = "select id,name,price,type,img_path from barbecue_tb order by price desc";
        return queryForList(Barbecue.class,sql);
    }

    @Override
    public List<Barbecue> queryByType(String type) {
        String sql = "select id,name,price,type,img_path from barbecue_tb where type=?";
        return queryForList(Barbecue.class,sql,type);
    }
}
