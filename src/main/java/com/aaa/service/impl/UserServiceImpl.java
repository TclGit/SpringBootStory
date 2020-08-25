package com.aaa.service.impl;

import com.aaa.dao.UserDao;
import com.aaa.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl {

    @Resource
    private UserDao userDao;


    public List<User> findAll(){
        return userDao.findAll();
    }
    public Integer addUser(User user){
        return userDao.addUser(user);
    }

    public Integer updateUser(User user){
        return userDao.updateUser(user);
    }

    public Integer deleteUser(Integer uid){
        return userDao.deleteUser(uid);
    }

    public Integer updateState(Integer state,Integer uid){
        System.out.println("impl"+uid+""+state);
        return userDao.updateState(state,uid);
    }
}
