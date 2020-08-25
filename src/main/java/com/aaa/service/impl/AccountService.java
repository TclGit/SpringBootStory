package com.aaa.service.impl;

import com.aaa.dao.AccountDao;
import com.aaa.entity.Account;
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

    public Integer update(Account account){
        return accountDao.update(account);
    }

    public Integer del(Integer aid){
        return accountDao.del(aid);
    }
}
