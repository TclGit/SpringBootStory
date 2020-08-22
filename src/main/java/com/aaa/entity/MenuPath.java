package com.aaa.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (MenuPath)实体类
 *
 * @author makejava
 * @since 2020-08-21 20:00:57
 */
@Data
public class MenuPath implements Serializable {

    private Integer id;

    private String pathurl;

    private String memo;

    private Integer menuid;

}