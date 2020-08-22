package com.aaa.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-08-21 20:03:03
 */

@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 576973724689172979L;

    private Integer rid;

    private String rname;

    private String roledesc;

    private String rolecode;

    private Integer states;

    private Date createtime;

}