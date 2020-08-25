package com.aaa.service;

import com.aaa.entity.Account;

import java.util.List;
import java.util.Map;


/**
 * 田常乐
 */
public interface PromissionService {

    //根据登录账号拿信息
    Account findAccountByName(String account);


    //根据登录账号拿出角色列表
    List<String> findRoleByAccount(String account);


    //根据账号拿出权限
    List<String> findPathByAccount(String account);


    //拿权限
    List<Map<String,Object>> findPromiss(Integer accountid);

    public List<Map<String,Object>> findByRoleId(Integer rid);

    List<Map<String,Object>> findPermiSsionInfo();

}
