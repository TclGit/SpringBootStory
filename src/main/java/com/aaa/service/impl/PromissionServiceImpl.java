package com.aaa.service.impl;

import com.aaa.dao.PromissionDao;
import com.aaa.entity.Account;
import com.aaa.service.PromissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PromissionServiceImpl implements PromissionService {


    @Resource
    PromissionDao promissionDao;

    @Override
    public List<Map<String, Object>> findPromiss(Integer accountid) {
        List<Map<String, Object>> list = promissionDao.findPromiss(accountid, 0);
        for(Map<String, Object> map : list){
            Integer pid = Integer.parseInt(map.get("id").toString());
            List<Map<String, Object>> res = promissionDao.findPromiss(accountid, pid);
            map.put("child",res);
        }
        return list;
    }

    @Override
    public Account findAccountByName(String account) {
        System.out.println(account);
        return promissionDao.findAccountByName(account);
    }

    @Override
    public List<String> findRoleByAccount(String account) {
        return promissionDao.findRoleByAccount(account);
    }

    @Override
    public List<String> findPathByAccount(String account) {
        return promissionDao.findPathByAccount(account);
    }
}
