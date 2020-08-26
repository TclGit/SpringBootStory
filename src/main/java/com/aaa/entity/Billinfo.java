package com.aaa.entity;

import lombok.Data;

@Data
public class Billinfo {
//    编号	bid
    private Integer bid;

//    收支类型	btype
    private Integer btype;

//    金额	bdesc
    private Double bdesc;

//    用户id	uid
    private Integer uid;

//    收支时间	btime
    private String btime;

    private User user;
}
