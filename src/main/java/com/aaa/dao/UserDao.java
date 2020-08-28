package com.aaa.dao;

import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;

import java.util.List;

public interface UserDao {

    /**
     * 后台
     * @return
     */
    //分页查询
    PageInfo<User> showPageInfo(Integer pageNum, Integer pageSize);

    List<User> findAll();
    //修改用户的状态
    Integer updateState(Integer uid, Integer state);

    Integer addUser(User user);
//前台
   List<User> userLogin(Integer phone, String pwd);





}
