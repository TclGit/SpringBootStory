package com.aaa.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Employee)实体类
 *
 * @author makejava
 * @since 2020-08-21 20:07:21
 */
@Data
public class Employee implements Serializable {

    private Integer eid;

    private String ename;

    private String sex;

    private Integer phone;

    private String pro;

    private String addr;

    private String idcard;

    private String email;

    private Integer state;

    private Integer cid;

}