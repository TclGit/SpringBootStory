package com.aaa.dao;

import com.aaa.entity.StoryContest;

import java.util.List;

public interface StoryContestDao {
    List<StoryContest> listAll();

    Integer add(StoryContest storyContest);

    Integer update(StoryContest storyContest);
}
