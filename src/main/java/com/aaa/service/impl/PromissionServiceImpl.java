package com.aaa.service.impl;

import com.aaa.dao.PromissionDao;
import com.aaa.entity.Account;
import com.aaa.service.PromissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * 田常乐
 */
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
    public List<Map<String,Object>> findByRoleId(Integer rid) {
        return promissionDao.findByRoleId(rid);
    }

    @Override
    public List<Map<String, Object>> findPermiSsionInfo() {
        //查询出的所有一级节点
        List<Map<String, Object>> list = promissionDao.findPermiSsionInfo(null);
        //查询出一级节点下的二级节点
        for(Map<String, Object> map : list){
            Integer menupid = Integer.parseInt(map.get("id").toString());
            List<Map<String, Object>> node = promissionDao.findPermiSsionInfo(menupid);
            map.put("children",node);
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
