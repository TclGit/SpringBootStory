package com.aaa.service.impl;

import com.aaa.dao.CommentDao;
import com.aaa.entity.Comment;
import com.aaa.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 马琳
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentDao commentDao;

    @Override
    public List<Comment> listAll_Comment() {
        return commentDao.listAll_Comment();
    }
}
