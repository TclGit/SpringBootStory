package com.aaa.entity;

import lombok.Data;

@Data
public class Replay {
//    编号	rid
    private Integer rid;

//    回复内容	rcontent
    private String rcontent;

//    回复评论id	cid
    private Integer cid;

//    回复人	uid
    private Integer uid;

//    回复时间	replaytime
    private String replaytime;

//    评论人	replayid
    private Integer replayid;

//    评论表
    private Comment comment;

//    用户表
    private User user;

    private User users;
}
