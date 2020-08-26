package com.aaa.service.impl;

import com.aaa.dao.RoleMenuDao;
import com.aaa.service.RoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class RoleMenuServiceImpl implements RoleMenuService {

    @Resource
    RoleMenuDao roleMenuDao;

    @Override
    public Integer add(Integer rid, Integer pid) {
        return roleMenuDao.add(rid,pid);
    }

    @Override
    public Integer del(Integer rid) {
        return roleMenuDao.del(rid);
    }
}
