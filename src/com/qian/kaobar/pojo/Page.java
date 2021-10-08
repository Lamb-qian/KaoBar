package com.qian.kaobar.pojo;

import java.util.List;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-16 20:43
 */
public class Page<T> {
    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "items=" + items +
                '}';
    }
}
