package com.aaa.dao;

import com.aaa.entity.Story;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoryDao {

    List<Story> listAll(@Param("rs") boolean rs);

    int update(Story story);
}
