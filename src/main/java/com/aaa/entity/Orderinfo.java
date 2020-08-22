package com.aaa.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Orderinfo)实体类
 *
 * @author makejava
 * @since 2020-08-21 20:05:01
 */
@Data
public class Orderinfo implements Serializable {

    private Integer oid;

    private String orderid;

    private Integer orderstate;

    private Integer cid;

    private Integer uid;

}