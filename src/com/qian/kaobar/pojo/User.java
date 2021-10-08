package com.qian.kaobar.pojo;

/**
 * @author LambQian
 * @Description
 * @create 2021-06-16 20:43
 */
public class User {
    private Integer id;
    private String name;
    private String password;
    private String tel;
    private String address;
    //0普通用户 1管理员
    private Integer power=0;

    public User() {
    }

    public User(String name, String password, String tel, String address) {
        this.name = name;
        this.password = password;
        this.tel = tel;
        this.address = address;
    }

    public User(Integer id, String name, String password, String tel, String address, Integer power) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.tel = tel;
        this.address = address;
        this.power = power;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", power=" + power +
                '}';
    }
}
