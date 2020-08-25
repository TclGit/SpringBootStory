package com.aaa.service;

import org.apache.catalina.User;

import java.util.List;

public interface UserService {


    List<User> findAll();

    Integer addUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer uid);
    //修改用户的状态
    Integer updateState(Integer uid,Integer state);

}
