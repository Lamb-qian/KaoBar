package com.qian.kaobar.service;

import com.qian.kaobar.pojo.Barbecue;
import com.qian.kaobar.pojo.Page;

import java.util.List;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 14:39
 */
public interface BarbecueService {
    /**
     * 添加食材
     * @param bar
     * @return
     */
    boolean addBar(Barbecue bar);

    /**
     * 删除食材
     * @param id
     * @return
     */
    boolean delBar(int id);

    /**
     * 更新食材
     * @param bar
     * @return
     */
    boolean updateBar(Barbecue bar);

    /**
     * 通过id查询食材并返回食材
     * @param id
     * @return
     */
    Barbecue queryById(Integer id);

    /**
     * 查询所有食材
     * @return
     */
    List<Barbecue> queryAllBar();

    /**
     * 通过价格区间查询食材
     * @param min
     * @param max
     * @return
     */
    Page<Barbecue> queryByPrice(int min, int max);

    /**
     * 根据价格升序排序查询食材
     * @return
     */
    Page<Barbecue> sortUpByPrice();

    /**
     * 根据价格降序查询食材
     * @return
     */
    Page<Barbecue> sortDownByPrice();

    /**
     * 根据食材类型查询食材
     * @param type
     * @return
     */
    Page<Barbecue> pageByType(String type);

    /**
     * 查询所有食材到Page中
     * @return
     */
    Page<Barbecue> page();
}
