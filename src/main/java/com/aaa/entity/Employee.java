package com.aaa.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

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

    //账号表
    private Account accounts;

    private AccountRole accountRole;

    private Role role;

}