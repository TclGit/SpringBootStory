package com.aaa.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class MenuPath implements Serializable {

    private Integer id;

    private String pathurl;

    private String memo;

    private Integer menuid;

    private Menu menu;

}