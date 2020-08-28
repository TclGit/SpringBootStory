package com.aaa.service;

import com.aaa.entity.Account;
import com.aaa.entity.Employee;

import java.util.List;


/**
 * 田常乐
 */
public interface EmpService {

    List<Employee> findall();

    Integer add(Employee employee);

    Integer delete(Integer eid);

    Integer update(Employee employee);

    List<Employee> listAllEmployee(Integer aid);

    Integer updateState(Integer eid);

    String findAccout(Integer id);

    String findRoleName(Integer id);

    List<Account> findNotUserAccount();

    String findRoleByAccount(Integer aid);

    Integer updateAccout(Integer aid,Integer eid);
}
