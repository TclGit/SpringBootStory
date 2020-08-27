package com.aaa.entity;

import lombok.Data;

@Data
public class StoryContest {
    private Integer scid;
    private String scname;
    private String scdesc;
    private Integer tid;
    private Integer scstate;
    private Integer storycount;
    private ThemeInfo themeInfo;
    private Theme_type theme_type;
}
