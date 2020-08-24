package com.aaa.entity;

//任帝
public class Theme_type {


    private Integer typeid;//编号

    private String typename;//类型名称

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "Theme_type{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                '}';
    }
}
