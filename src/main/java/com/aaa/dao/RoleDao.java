package com.aaa.dao;

import com.aaa.entity.Role;

import java.util.List;

public interface RoleDao {

    List<Role> findAllRole();

    int update(Role role);

}
