package com.aaa.dao;

import org.apache.catalina.User;

import java.util.List;

public interface UserDao {

    /**
     * 后台
     * @return
     */
    List<User> findAll();
    //修改用户的状态
    Integer updateState(Integer uid,Integer state);





    Integer addUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer uid);





}
