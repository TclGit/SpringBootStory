package com.aaa.service;

import com.aaa.entity.Employee;

import java.util.List;

public interface EmpService {

    List<Employee> findall();

    Integer add(Employee employee);

    Integer delete(Integer eid);

    Integer update(Employee employee);

}
