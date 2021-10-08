package com.qian.kaobar.test;

import com.qian.kaobar.pojo.Barbecue;
import com.qian.kaobar.service.BarbecueService;
import com.qian.kaobar.service.impl.BarbecueServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 15:51
 */
public class BarbecueServiceTest {
    BarbecueService service = new BarbecueServiceImpl();
    @Test
    public void addTest(){
        System.out.println(service.addBar(new Barbecue(null, "小羊排", BigDecimal.valueOf(10), "肉食", null)));
    }
}
