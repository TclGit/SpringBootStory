package com.aaa.service.impl;

import com.aaa.dao.RoleDao;
import com.aaa.entity.Role;
import com.aaa.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleDao roleDao;

    @Override
    public List<Role> findAllRole() {
        return roleDao.findAllRole();
    }

    @Override
    public int update(Role role) {
        return roleDao.update(role);
    }
}
