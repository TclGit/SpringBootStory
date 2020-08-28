package com.aaa.service.impl;


import com.aaa.dao.EmpInfoDao;
import com.aaa.entity.Account;
import com.aaa.entity.Employee;
import com.aaa.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 田常乐
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    EmpInfoDao empInfoDao;

    @Override
    public List<Employee> findall() {
        return empInfoDao.findall();
    }

    @Override
    public Integer add(Employee employee) {
        return empInfoDao.add(employee);
    }

    @Override
    public Integer delete(Integer eid) {
        return empInfoDao.delete(eid);
    }

    @Override
    public Integer update(Employee employee) {
        return empInfoDao.update(employee);
    }

    @Override
    public List<Employee> listAllEmployee(Integer aid) {
        List<Employee> employees = empInfoDao.listAllEmployee(aid);
        return employees;
    }

    @Override
    public Integer updateState(Integer eid) {
        return empInfoDao.updateState(eid);
    }

    @Override
    public String findAccout(Integer id) {
        return empInfoDao.findAccout(id);
    }

    @Override
    public String findRoleName(Integer id) {
        return empInfoDao.findRoleName(id);
    }

    @Override
    public List<Account> findNotUserAccount() {
        return empInfoDao.findNotUserAccount();
    }

    @Override
    public String findRoleByAccount(Integer aid) {
        return empInfoDao.findRoleByAccount(aid);
    }

    @Override
    public Integer updateAccout(Integer aid, Integer eid) {
        return empInfoDao.updateAccout(aid,eid);
    }
}
