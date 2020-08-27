package com.aaa.service.impl;

import com.aaa.dao.ThemeInfoDao;
import com.aaa.entity.ThemeInfo;
import com.aaa.entity.Theme_type;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ThemeInfoImpl implements ThemeInfoDao {
    @Resource
    ThemeInfoDao themeInfoDao;

//    主题表
    public List<ThemeInfo> queryAll_a(boolean rs,boolean res){
        return themeInfoDao.queryAll_a(rs,res);
    }

//    主题分类-类型名称
    public List<Theme_type> queryAll_b(){
        return themeInfoDao.queryAll_b();
    }

    public int add(ThemeInfo themeInfo){
        return themeInfoDao.add(themeInfo);
    }

    public int update(ThemeInfo themeInfo){
        return themeInfoDao.update(themeInfo);
    }

    public int delete_b(Integer tid){
        return themeInfoDao.delete_b(tid);
    }

}
