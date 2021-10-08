package com.qian.kaobar.service.impl;

import com.qian.kaobar.dao.BarbecueDao;
import com.qian.kaobar.dao.impl.BarbecueDaoImpl;
import com.qian.kaobar.pojo.Barbecue;
import com.qian.kaobar.pojo.Page;
import com.qian.kaobar.service.BarbecueService;

import java.util.List;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 15:06
 */
public class BarbecueServiceImpl implements BarbecueService {
    BarbecueDao barDao = new BarbecueDaoImpl();

    @Override
    public boolean addBar(Barbecue bar) {
        return barDao.addBar(bar);
    }

    @Override
    public boolean delBar(int id) {
        return barDao.delBar(id);
    }

    @Override
    public boolean updateBar(Barbecue bar) {
        return barDao.updateBar(bar);
    }

    @Override
    public Barbecue queryById(Integer id) {
        return barDao.queryById(id);
    }

    @Override
    public List<Barbecue> queryAllBar() {
        return barDao.queryAllBar();
    }

    @Override
    public Page<Barbecue> queryByPrice(int min, int max) {
        return retPage(barDao.queryByPrice(min,max));
    }

    @Override
    public Page<Barbecue> sortUpByPrice() {
        return retPage(barDao.sortUpByPrice());
    }

    @Override
    public Page<Barbecue> sortDownByPrice() {
        return retPage(barDao.sortDownByPrice());
    }

    @Override
    public Page<Barbecue> pageByType(String type) {
        return retPage(barDao.queryByType(type));
    }

    @Override
    public Page<Barbecue> page() {
        return retPage(barDao.queryAllBar());
    }

    public Page<Barbecue> retPage(List<Barbecue> bar){
        Page<Barbecue> page = new Page<>();
        page.setItems(bar);
        return page;
    }
}
