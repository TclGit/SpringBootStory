package com.aaa.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Orderinfo implements Serializable {

    private Integer oid;

    private String orderid;

    private Integer orderstate;

    private Integer cid;

    private Integer uid;

}