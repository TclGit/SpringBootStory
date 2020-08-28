package com.aaa.service.impl;

import com.aaa.dao.UserDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl {

    @Resource
    private UserDao userDao;

//后台
    public List<User> findAll() {
        return userDao.findAll();
    }
    public PageInfo<User> showPageInfo(Integer pageNum, Integer pageSize){
        System.out.println("分页走service");
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userDao.findAll();
        System.out.println("userList:"+userList);
        PageInfo<User> pageInfo = new PageInfo<>(userList);

        System.out.println("pageInfo:"+pageInfo);
        return pageInfo;
    }

    public Integer updateState(Integer state,Integer uid){
        System.out.println("impl"+uid+""+state);
        return userDao.updateState(state,uid);
    }


  //前台

  public List<User> userLogin(Integer phone,String pwd){
      System.out.println("前台登录service方法");
      return userDao.userLogin(phone,pwd);
  }


    public Integer addUser(User user){
        return userDao.addUser(user);
    }


}
