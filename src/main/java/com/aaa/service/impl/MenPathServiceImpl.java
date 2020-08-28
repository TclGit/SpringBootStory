package com.aaa.service.impl;

import com.aaa.dao.RourceDao;
import com.aaa.entity.MenuPath;
import com.aaa.service.MenuPathService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MenPathServiceImpl implements MenuPathService {

    @Resource
    RourceDao rourceDao;

    @Override
    public List<MenuPath> findMenPath() {
        return rourceDao.findMenuPath();
    }
}
