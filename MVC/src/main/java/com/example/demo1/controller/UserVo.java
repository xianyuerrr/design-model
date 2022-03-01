package com.example.demo1.controller;

import java.util.Objects;

/**
 * @auther xianyue
 * @date 2022/2/12 - 星期六 - 20:44
 **/
public class UserVo {
    private  Long id;
    private  String name;
    private String cellphone;

    public UserVo() {
    }

    public UserVo(Long id, String name, String cellphone) {
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
        UserVo userVo = (UserVo) o;
        return getId().equals(userVo.getId()) && getName().equals(userVo.getName()) && Objects.equals(getCellphone(), userVo.getCellphone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCellphone());
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }
}
