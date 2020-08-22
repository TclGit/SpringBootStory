package com.aaa.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (AccountRole)实体类
 *
 * @author makejava
 * @since 2020-08-21 20:08:57
 */
@Data
public class AccountRole implements Serializable {

    private Integer id;

    private Integer aid;

    private Integer rid;


}