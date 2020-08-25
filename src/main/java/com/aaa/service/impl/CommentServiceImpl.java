package com.aaa.service.impl;

import com.aaa.dao.CommentDao;
import com.aaa.entity.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 马琳
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentDao{

    @Resource
    CommentDao commentDao;

    public List<Comment> listAll() {
        return commentDao.listAll();
    }
}
