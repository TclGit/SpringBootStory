package com.aaa.dao;

import com.aaa.entity.Story;

import java.util.List;

public interface StoryDao {

    List<Story> listAll();

    int update(Story story);
}
