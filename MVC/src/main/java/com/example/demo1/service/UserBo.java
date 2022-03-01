package com.example.demo1.service;

import java.util.Objects;

/**
 * @auther xianyue
 * @date 2022/2/12 - 星期六 - 20:32
 **/
public class UserBo {
    private Long id;
    private  String name;
    private String cellphone;

    public UserBo() {
    }

    public UserBo(Long id, String name, String cellphone) {
        this.id = id;
        this.name = name;
        this.cellphone = cellphone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBo userBo = (UserBo) o;
        return getId().equals(userBo.getId()) && getName().equals(userBo.getName()) && Objects.equals(getCellphone(), userBo.getCellphone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCellphone());
    }

    @Override
    public String toString() {
        return "UserBo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }
}
