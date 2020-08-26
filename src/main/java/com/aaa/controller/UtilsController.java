package com.aaa.controller;

import com.aaa.entity.*;
import com.aaa.service.*;
import com.aaa.service.impl.AccountService;
import com.aaa.service.impl.StoryServiceImpl;
import com.aaa.service.impl.ThemetypeImpl;
import com.aaa.service.impl.UserServiceImpl;
import com.aaa.until.Alipay;
import com.aaa.until.JwtUtils;
import com.alipay.api.AlipayApiException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("utils")
public class UtilsController {


    @Resource
    PromissionService promissionService;

    @Resource
    EmpService empService;

    @Resource
    RoleService roleService;

    @Resource
    RoleMenuService roleMenuService;

    @Resource
    private Alipay aliPay;

    /**
     * @author 田常乐  权限查询
     * @param request
     * @return
     */
    @RequestMapping("find")
    public Object find(HttpServletRequest request){
        String token = request.getHeader("token");
        DecodedJWT verify = JwtUtils.verify(token);
        String id = verify.getClaim("id").asString();
        List<Map<String, Object>> promiss = promissionService.findPromiss(Integer.parseInt(id));
        return promiss;
    }

    /**
     * @author 田常乐  员工增删改查
     * @return
     */
    @RequestMapping("findemp")
    public List<Employee> findall()
    {
        return empService.findall();
    }


    @RequestMapping(value = "add",method = RequestMethod.POST )
    public Integer add(@RequestBody Employee employee)
    {
        System.out.println();
        return empService.add(employee);
    }

    @RequestMapping(value = "delete/{eid}",method = RequestMethod.GET )
    public Integer delete(@PathVariable("eid") Integer eid)
    {
        return empService.delete(eid);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Integer update(@RequestBody Employee employee)
    {
        System.out.println(employee);
        return empService.update(employee);
    }

    /**
     * 田常乐  权限查询修改
     */
    @RequestMapping("findAllRole")
    public List<Role> findAllRole()
    {
        return roleService.findAllRole();
    }

    /**
     * 田常乐
     * 根据角色id查询显示权限
     */
    @RequestMapping(value = "findByRoleId/{rid}",method = RequestMethod.POST )
    public Object findByRoleId(@PathVariable("rid") Integer rid)
    {
        List<Map<String,Object>> promis = promissionService.findByRoleId(rid);
        System.out.println(promis);
        return promis;
    }

    /**
     * 田常乐
     * 权限分配
     */
    @RequestMapping("findPermiSsionInfo")
    public Object  findPermiSsionInfo()
    {
        List<Map<String, Object>> permiSsionInfo = promissionService.findPermiSsionInfo();
        System.out.println(permiSsionInfo);
        return permiSsionInfo;
    }

    @RequestMapping(value = "RoleMenu",method = RequestMethod.PUT)
    public void RoleMenu(Integer rid,int[] keys)
    {
        System.out.println(rid+""+keys);
        roleMenuService.del(rid);
        for (int i = 0;i<=keys.length-1;i++)
        {
            roleMenuService.add(rid,keys[i]);
        }
    }

    /**
     * 田常乐
     *
     * 支付宝
     * @param alipayUntil
     * @return
     * @throws AlipayApiException
     */
    @PostMapping(value = "order/alipay")
    public String alipay(@RequestBody AlipayUntil alipayUntil) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(alipayUntil.getOutTradeNo());
        alipayBean.setSubject(alipayUntil.getSubject());
        alipayBean.setTotal_amount(alipayUntil.getTotalAmout());
        alipayBean.setBody(alipayUntil.getBody());
        System.out.println(alipayBean);
        return aliPay.pay(alipayBean);
    }

    /**
     * 王勇琦 角色修改
     * @param role
     * @return
     */
    @RequestMapping("role_update")
    public int update(@RequestBody Role role){
        int update = roleService.update(role);
        if(update == 1){
            return update;
        }else {
            return 0;
        }
    }

    @Resource
    StoryServiceImpl storyService;

    @RequestMapping("story_listAll")
    public List<Story> story_listAll(boolean rs){
        List<Story> stories = storyService.listAll(rs);
        System.out.println(rs);
        return stories;
    }

    @RequestMapping("story_update")
    public int story_update(@RequestBody Story story){
        return storyService.update(story);
    }


    @RequestMapping("personal_center")
    public Object personal_center(HttpServletRequest request){
        String token = request.getHeader("token");
        DecodedJWT verify = JwtUtils.verify(token);
        String id = verify.getClaim("id").asString();
        Integer aid = Integer.parseInt(id);
        return empService.listAllEmployee(aid);
    }


    /**
     * 马琳 账号增删改
     * @param role
     * @return
     */
    @Resource
    AccountService accountService;

    @ResponseBody
    @RequestMapping("ListAll")
    public Object list(){
        List<Account> accounts = accountService.ListAll();
        return accounts;
    }

    @ResponseBody
    @RequestMapping("insert")
    public Object insert(@RequestBody Account account){
        //获取后台传来的密码，并进行转码操作
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(account.getPassword());
        account.setPwd(encode);
        Integer insert = accountService.insert(account);
        if (insert ==1){
            return insert;
        }else {
            return 0;
        }
    }

    @ResponseBody
    @RequestMapping("update_account")
    public Object update(@RequestBody Account account){
        Integer update = accountService.update(account);
        if (update ==1){
            return update;
        }else {
            return 0;
        }
    }

    @ResponseBody
    @RequestMapping("del")
    public Object del(@RequestBody Map map){
        Integer del = accountService.del((Integer) map.get("aid"));
        if (del == 1){
            return del;
        }else {
            return 0;
        }
    }





    /**
     * 马琳 收支明细
     */

    @Resource
    BillInfoService billInfoService;

    @RequestMapping("listAll_BillInfo")
    public List<Billinfo> listAllBillInfo(){
        List<Billinfo> billinfos = billInfoService.listAll_BillInfo();
        return billinfos;
    }

    //任帝 主题分类的增删改查
    @Resource
    private ThemetypeImpl themetypeimpl;


    @ResponseBody
    @RequestMapping("queryAll")
    public List<Theme_type> queryAll(){
        List<Theme_type> Them = themetypeimpl.queryAll();
        return Them;
    }

    @ResponseBody
    @RequestMapping("add_Type")
    public int add(@RequestBody Theme_type theme_type){
        Integer add = themetypeimpl.add(theme_type);
        if (add == 1){
            return add;
        }else {
            return 0;
        }
    }


    @ResponseBody
    @RequestMapping("update_Themetype")
    public int update(@RequestBody Theme_type theme_type){
        Integer update = themetypeimpl.update(theme_type);
        if (update == 1){
            return update;
        }else {
            return 0;
        }
    }

    @ResponseBody
    @RequestMapping("delete")
    public int delete(@RequestBody Map map){
        Integer del = themetypeimpl.delete((Integer) map.get("typeid"));
        if (del == 1){
            return del;
        }else {
            return 0;
        }
    }






    //李慧敏的专属类型
    @Resource
    private UserServiceImpl userServiceImpl;

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
