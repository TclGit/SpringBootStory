package com.aaa.dao;

import com.aaa.entity.Account;

import java.util.List;
import java.util.Map;


public interface PromissionDao {

   //根据登录账号拿信息
   public Account findAccountByName(String account);


   //根据登录账号拿出角色列表
   public List<String> findRoleByAccount(String account);


   //根据账号拿出权限
   public List<String> findPathByAccount(String account);


   public List<Map<String,Object>> findPromiss(Integer account,Integer menupid);


}
