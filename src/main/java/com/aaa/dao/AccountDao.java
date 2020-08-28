package com.aaa.dao;

import com.aaa.entity.Account;
import com.aaa.entity.Role;

import java.util.List;

public interface AccountDao {
    //    查询
    List<Account> ListAll();

    //    添加
    Integer insert(Account account);

    //授予角色
    Integer update(Integer aid,Integer rid);

    //查询账号所拥有的角色
    String findRole(Integer aid);

    //查询所有角色
    List<Role> findAllRole();

    //锁定账号
    Integer updateAccount(Integer aid);

    //解锁账号
    Integer updateUnAccount(Integer aid);


    //李慧敏   账号表密码修改
    String selectPwd(String pwd);


    Integer updatePwd(String pwd,Integer aid);


    List<Account>  findAid(String aid);
}
