package com.aaa.service;

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

    Employee listAllEmployee(Integer aid);
}
