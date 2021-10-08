package com.qian.kaobar.pojo;

import java.math.BigDecimal;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-16 20:43
 */
public class Barbecue {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String type;
    private String img_path="";

    public Barbecue() {
    }

    public Barbecue(Integer id, String name, BigDecimal price, String type, String img_path) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.img_path = img_path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    @Override
    public String toString() {
        return "Barbecue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", img_path='" + img_path + '\'' +
                '}';
    }
}
