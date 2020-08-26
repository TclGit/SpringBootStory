package com.aaa.service.impl;

import com.aaa.dao.ReplayDao;
import com.aaa.entity.Replay;
import com.aaa.service.ReplayService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ReplayServiceImpl implements ReplayService {
    @Resource
    ReplayDao replayDao;

    @Override
    public List<Replay> listAll_Replay() {
        List<Replay> replays = replayDao.listAll_Replay();
        return replays;
    }
}
