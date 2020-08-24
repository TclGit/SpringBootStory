package com.aaa.service;

import com.aaa.entity.Role;

import java.util.List;


/**
 * 田常乐
 */
public interface RoleService {

    List<Role> findAllRole();

    int update(Role role);

}
