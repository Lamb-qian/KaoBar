package com.qian.kaobar.test;

import com.qian.kaobar.dao.BarbecueDao;
import com.qian.kaobar.dao.impl.BarbecueDaoImpl;
import com.qian.kaobar.pojo.Barbecue;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 10:42
 */
public class BarbecueDaoImplTest {
    BarbecueDao barDao = new BarbecueDaoImpl();

    @Test
    public void addTest(){
        System.out.println(barDao.addBar(new Barbecue(null, "羊排", BigDecimal.valueOf(10), "肉食", null)));
    }
    @Test
    public void delTest(){
        System.out.println(barDao.delBar(4));
    }
    @Test
    public void updateTest(){
        System.out.println(barDao.updateBar(new Barbecue(4, "大羊排", BigDecimal.valueOf(8), "肉食", null)));
    }
    @Test
    public void qTest(){
        System.out.println(barDao.queryAllBar());
    }

}
