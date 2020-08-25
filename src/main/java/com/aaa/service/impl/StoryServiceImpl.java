package com.aaa.service.impl;

import com.aaa.dao.StoryDao;
import com.aaa.entity.Story;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class StoryServiceImpl implements StoryDao {

    @Resource
    StoryDao storyDao;


    @Override
    public List<Story> listAll() {
        List<Story> stories = storyDao.listAll();
        return stories;
    }

    @Override
    public int update(Story story) {
        int i = storyDao.update(story);
        if(i == 1){
            return i;
        }else{
            return 0;
        }
    }
}
