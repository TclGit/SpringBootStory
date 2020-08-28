package com.aaa.dao;

import com.aaa.entity.Account;
import com.aaa.entity.Employee;

import java.util.List;

public interface EmpInfoDao {

    List<Employee> findall();

    Integer add(Employee employee);

    Integer delete(Integer eid);

    Integer update(Employee employee);

    List<Employee> listAllEmployee(Integer aid);

    //修改员工的状态信息
    Integer updateState(Integer eid);

    //查询员工所拥有的账号信息
    String findAccout(Integer id);

    //查询账号对应的角色信息
    String findRoleName(Integer id);

    //查找没有被分配的账号
    List<Account> findNotUserAccount();

    //查询账号对应的角色
    String findRoleByAccount(Integer aid);

    Integer updateAccout(Integer aid,Integer eid);


}
