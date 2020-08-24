package com.aaa.dao;

import com.aaa.entity.Account;

import java.util.List;

public interface AccountDao {
    //    查询
    List<Account> ListAll();

    //    添加
    Integer insert(Account account);

    //    修改
    Integer update(Account account);

    //    删除
    Integer del(Integer aid);


    //李慧敏   账号表密码修改
    Integer updatePwd(String account,String pwd);
}
