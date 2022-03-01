package com.example.demo1.repository;

/**
 * @auther xianyue
 * @date 2022/2/12 - 星期六 - 20:30
 **/
public class UserEntity {
    private  Long id;
    private String name;
    private String cellphone;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String cellphone) {
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

        UserEntity that = (UserEntity) o;

        if (!getId().equals(that.getId())) return false;
        if (!getName().equals(that.getName())) return false;
        return getCellphone() != null ? getCellphone().equals(that.getCellphone()) : that.getCellphone() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getCellphone() != null ? getCellphone().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }
}
