package com.aaa.service.impl;


import com.aaa.dao.EmpInfoDao;
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


}
