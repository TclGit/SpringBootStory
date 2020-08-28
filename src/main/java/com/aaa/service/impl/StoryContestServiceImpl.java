package com.aaa.service.impl;

import com.aaa.dao.StoryContestDao;
import com.aaa.entity.StoryContest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class StoryContestServiceImpl implements StoryContestDao {

    @Resource
    StoryContestDao storyContestDao;

    @Override
    public List<StoryContest> listAll() {
        return storyContestDao.listAll();
    }

    @Override
    public Integer add(StoryContest storyContest) {
        Integer add = storyContestDao.add(storyContest);
        if(add == 1){
            return add ;
        }else{
            return 0;
        }
    }

    @Override
    public Integer update(StoryContest storyContest) {
        Integer update = storyContestDao.update(storyContest);
        if(update == 1){
            return update ;
        }else{
            return 0;
        }
    }

}
