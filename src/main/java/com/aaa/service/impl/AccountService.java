package com.aaa.service.impl;

import com.aaa.dao.AccountDao;
import com.aaa.entity.Account;
import com.aaa.entity.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/***
 * 马琳
 */
@Service
@Transactional
public class AccountService implements AccountDao {

    @Resource
    AccountDao accountDao;

    public List<Account> ListAll(){
        return accountDao.ListAll();
    }

    public Integer insert(Account account){
        return accountDao.insert(account);
    }

    public Integer update(Integer aid,Integer rid){
        return accountDao.update(aid,rid);
    }

    @Override
    public String findRole(Integer aid) {
        return accountDao.findRole(aid);
    }

    @Override
    public List<Role> findAllRole() {
        return accountDao.findAllRole();
    }

    @Override
    public Integer updateAccount(Integer aid) {
        return accountDao.updateAccount(aid);
    }

    @Override
    public Integer updateUnAccount(Integer aid) {
        return accountDao.updateUnAccount(aid);
    }


    @Override
    public String selectPwd(String pwd) {
        return accountDao.selectPwd(pwd);
    }


    @Override
    public Integer updatePwd(String pwd,Integer aid) {
        return accountDao.updatePwd(pwd,aid);
    }

    @Override
    public List<Account> findAid(String aid) {
        return accountDao.findAid(aid);
    }
}
