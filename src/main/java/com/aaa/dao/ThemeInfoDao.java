package com.aaa.dao;

import com.aaa.entity.ThemeInfo;
import com.aaa.entity.Theme_type;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ThemeInfoDao {
    List<ThemeInfo> queryAll_a(@Param("rs") boolean rs,@Param("res") boolean res);//主题表

    List<Theme_type> queryAll_b();//主题分类-类型名称

    int add(ThemeInfo themeInfo);

    int update(ThemeInfo themeInfo);

    int delete_b(Integer tid);
}
