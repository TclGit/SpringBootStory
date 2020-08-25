package com.aaa.dao;

import com.aaa.entity.Employee;

import java.util.List;

public interface EmpInfoDao {

    List<Employee> findall();

    Integer add(Employee employee);

    Integer delete(Integer eid);

    Integer update(Employee employee);

    List<Employee> listAllEmployee(Integer aid);
}
