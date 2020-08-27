package com.aaa.entity;

import lombok.Data;

import java.util.Date;

/*
    任帝：
        themeinfo
        主题表
 */
@Data
public class ThemeInfo {
//    编号
    private Integer tid;

//    主题名
    private String tname;

//    主题描述
    private String tdesc;

//    封面图
    private String coverpic;

//    主题类型
    private Integer typeid;

//    用户id
    private Integer uid;

//    主题状态
    private Integer state;

//    开始时间
    private Date  starttime;

//    结束时间
    private Date endtime;

    private Theme_type theme_type;

    private User user;
}
