package com.qian.kaobar.dao;

import com.qian.kaobar.pojo.Barbecue;

import java.util.List;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-17 9:39
 */
public interface BarbecueDao {

    /**
     * 添加食材
     * @param bar
     * @return
     */
    boolean addBar(Barbecue bar);

    /**
     * 通过id删除食材
     * @param id
     * @return
     */
    boolean delBar(Integer id);

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
    List<Barbecue> queryByPrice(int min,int max);

    /**
     * 根据价格升序排序查询食材
     * @return
     */
    List<Barbecue> sortUpByPrice();

    /**
     * 根据价格降序查询食材
     * @return
     */
    List<Barbecue> sortDownByPrice();

    /**
     * 根据食材类型查询食材
     * @param type
     * @return
     */
    List<Barbecue> queryByType(String type);
}
