package com.aaa.entity;

import lombok.Data;

@Data
public class Comment {

//    编号	cid
    private Integer cid;

//    评论内容	content
    private String content;

//    评论时间	ctime
    private String ctime;

//    评论人	uid
    private  Integer uid;

//    评论故事id	sid
    private Integer sid;
//关联故事
    private Story story;
//关联用户
    private User user;
}
