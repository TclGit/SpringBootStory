package com.aaa.dao;


import com.aaa.entity.Theme_type;

import java.util.List;

//任帝
public interface ThemetypeDao {
    List<Theme_type> queryAll();

    int add(Theme_type theme_type);

    int update(Theme_type theme_type);

    int delete(int typeid);

}
