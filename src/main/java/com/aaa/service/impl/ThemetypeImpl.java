package com.aaa.service.impl;

import com.aaa.dao.ThemetypeDao;
import com.aaa.entity.Theme_type;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//任帝
@Service
public class ThemetypeImpl {
    @Resource
    private ThemetypeDao themetypeService;

    public List<Theme_type> queryAll(){

        return themetypeService.queryAll();
    }

    public int add(Theme_type theme_type){

        return themetypeService.add(theme_type);
    }

    public int update(Theme_type theme_type){

        return themetypeService.update(theme_type);
    }

    public int delete(int typeid){

        return  themetypeService.delete(typeid);
    }
}
