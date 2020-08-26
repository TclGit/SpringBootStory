package com.aaa.service.impl;

import com.aaa.dao.BillInfoDao;
import com.aaa.entity.Billinfo;
import com.aaa.service.BillInfoService;

import javafx.util.Builder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BillInfoServiceImpl implements BillInfoService {

    @Resource
    BillInfoDao billInfoDao;

    @Override
    public List<Billinfo> listAll_BillInfo() {
        return billInfoDao.listAll_Bbillinfo();
    }
}
