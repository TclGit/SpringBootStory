package com.aaa.controller;

import com.aaa.service.PromissionService;
import com.aaa.service.impl.UserServiceImpl;
import com.aaa.until.JwtUtils;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("utils")
public class UtilsController {

    @Resource
    PromissionService promissionService;

    //李慧敏的专属类型
    @Resource
    private UserServiceImpl userServiceImpl;





    @RequestMapping("find")
    public Object find(HttpServletRequest request){
        String token = request.getHeader("token");

        DecodedJWT verify = JwtUtils.verify(token);
        String id = verify.getClaim("id").asString();

        List<Map<String, Object>> promiss = promissionService.findPromiss(Integer.parseInt(id));

        return promiss;
    }




    /***
     *    李慧敏的专属区
     *    findAll
     *    addUser
     *    updateUser
     *    deleteUser
     * @return
     */


    @RequestMapping(value = "findAll",method = RequestMethod.POST)
    public List<User> findAll(){
        System.out.println("用户查询Controller");
        return userServiceImpl.findAll();
    }


    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public Integer addUser(@RequestBody User user){
        return userServiceImpl.addUser(user);
    }


    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    @ResponseBody
    public Integer updateUser(@RequestBody User user){
        return userServiceImpl.updateUser(user);
    }


    /**
     * @PathVariable 映射 URL 绑定的占位符
     * @param uid
     * @return
     */
    @RequestMapping(value = "deleteUser/{uid}",method = RequestMethod.POST)
    public Integer deleteUser(@RequestBody @PathVariable("uid") Integer uid){
        return userServiceImpl.deleteUser(uid);
    }


    @RequestMapping(value = "updateState/{uid}/{state}",method = RequestMethod.POST)
    public Integer update(@PathVariable("state") Integer state,@PathVariable("uid") Integer uid){
        System.out.println("修改用户状态");
        System.out.println(state+""+uid);
        return userServiceImpl.updateState(state,uid);
    }


}
