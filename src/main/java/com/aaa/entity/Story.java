package com.aaa.entity;

import lombok.Data;

@Data
public class Story {
    private Integer sid;

    private String stitle;

    private String scontent;

    private String pic;

    private Integer givecount;

    private Integer browsecount;

    private Integer tid;

    private Integer state;

    private Integer uid;

    private Integer ifselected;

    private Integer ifrelease;

    private User users;

    private ThemeInfo themeInfo;
}
