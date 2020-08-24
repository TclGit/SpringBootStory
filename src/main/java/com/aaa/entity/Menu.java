package com.aaa.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Menu implements Serializable {

    private Integer id;

    private Integer menupid;

    private String menuname;

    private String child;

    private String path;

    private String routename;

    private String componentname;

    private String icon;

}