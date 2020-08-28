package com.aaa.controller;

import com.aaa.entity.*;
import com.aaa.service.*;
import com.aaa.service.impl.*;
import com.aaa.until.Alipay;
import com.aaa.until.EncodingPwdUtils;
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

    @RequestMapping("updateState/{eid}")
    public Integer updateState(@PathVariable("eid") Integer eid)
    {
        return empService.updateState(eid);
    }

    @RequestMapping("findAccount/{id}")
    public String findAccount(@PathVariable("id") Integer id)
    {
        return empService.findAccout(id);
    }

    @RequestMapping("findRoleName/{id}")
    public String findRoleName(@PathVariable("id") Integer id)
    {
        return empService.findRoleName(id);
    }

    @RequestMapping("findNotUserAccount")
    public List<Account> findNotUserAccount()
    {
        return empService.findNotUserAccount();
    }

    //List<Role> findRoleByAccount(Integer aid);
    @RequestMapping("findRoleByAccount/{aid}")
    public String findRoleByAccount(@PathVariable("aid") Integer aid)
    {
        return empService.findRoleByAccount(aid);
    }

    //updateAccout
    @RequestMapping("updateAccout/{aid}/{eid}")
    public Integer updateAccout(@PathVariable("aid") Integer aid,@PathVariable("eid") Integer eid)
    {
        return empService.updateAccout(aid,eid);
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
     * 资源管理
     */

    @Resource
    MenPathServiceImpl menPathService;

    @RequestMapping(value = "findMenuPath",method = RequestMethod.POST)
    public List<MenuPath> findMenuPath()
    {
        System.out.println(menPathService.findMenPath());
        return menPathService.findMenPath();
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
     * 王勇琦
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

    @Resource
    StoryContestServiceImpl storyContestService;
    @RequestMapping("storyContest_listAll")
    public List<StoryContest> storyContest_listAll(){
        return storyContestService.listAll();
    }

    @RequestMapping("storyContest_add")
    public int storyContest_add(@RequestBody StoryContest storyContest){
        System.out.println(storyContest);
        return storyContestService.add(storyContest);
    }

    @RequestMapping("storyContest_update")
    public int storyContest_update(@RequestBody StoryContest storyContest){
        System.out.println(storyContest);
        return storyContestService.update(storyContest);
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

    @RequestMapping("findRole/{aid}")
    public String findRole(@PathVariable("aid") Integer aid)
    {
        return accountService.findRole(aid);
    }

    @RequestMapping("queryRole")
    public List<Role> queryRole()
    {
        return accountService.findAllRole();
    }

    @RequestMapping("updateUnAccount/{aid}")
    public Integer updateUnAccount(@PathVariable("aid") Integer aid)
    {
        return accountService.updateUnAccount(aid);
    }

    @RequestMapping("updateaccount/{aid}/{rid}")
    public Integer updateaccount(@PathVariable("aid") Integer aid, @PathVariable("rid")Integer rid)
    {
        return accountService.update(aid,rid);
    }

    @RequestMapping("updateAccount/{aid}")
    public Integer updateAccount(@PathVariable("aid") Integer aid,HttpServletRequest request)
    {
        String token = request.getHeader("token");
        DecodedJWT verify = JwtUtils.verify(token);
        String id = verify.getClaim("id").asString();
        Integer num = Integer.parseInt(id);
        System.out.println(aid+"______"+num);
        System.out.println(aid==num);
        if(aid == num)
        {
            return 0;
        }
        else
        {
            System.out.println("你猜走没走");
            System.out.println(accountService.updateAccount(aid));
            return accountService.updateAccount(aid);
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

    //    任帝 主题表的增删改查

    @Resource

    ThemeInfoImpl themeInfoimpl;



    //    主题表

    @ResponseBody

    @RequestMapping("queryAll_ThemeInfo")

    public List<ThemeInfo> queryAll_a(boolean rs,boolean res){

        List<ThemeInfo> themeInfos = themeInfoimpl.queryAll_a(rs,res);

        return themeInfos;

    }



    //    主题分类-类型名称

    @RequestMapping("queryAll_ThemeInfo_typename")

    public List<Theme_type> queryAll_b(){

        List<Theme_type> theme_types = themetypeimpl.queryAll();

        System.out.println(theme_types);

        return theme_types;

    }



    @ResponseBody

    @RequestMapping("add_ThemeInfo")

    public int add(@RequestBody ThemeInfo themeInfo){

        int adds = themeInfoimpl.add(themeInfo);

        if(adds == 1){

            return adds;

        }else{

            return 0;

        }

    }



    @ResponseBody

    @RequestMapping("update_ThemeInfo")

    public int update(@RequestBody ThemeInfo themeInfo){

        int updates = themeInfoimpl.update(themeInfo);

        if(updates == 1){

            return updates;

        }else{

            return 0;

        }

    }



    @ResponseBody

    @RequestMapping("delete_ThemeInfo")

    public int delete_b(@RequestBody Map map){

        int deletes = themeInfoimpl.delete_b((Integer) map.get("tid"));

        if(deletes == 1){

            return deletes;

        }else{

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

    /**
     * @PathVariable 映射 URL 绑定的占位符
     * @param uid
     * @return
     */


    @RequestMapping(value = "updateState/{uid}/{state}",method = RequestMethod.POST)
    public Integer update(@PathVariable("state") Integer state,@PathVariable("uid") Integer uid){
        System.out.println("修改用户状态");
        System.out.println(state+""+uid);
        return userServiceImpl.updateState(state,uid);
    }


    //查询原密码
    @RequestMapping(value = "selectPwd",method = RequestMethod.POST)
    public Boolean selectPwd(HttpServletRequest request,@RequestBody String pwd){
        String str = pwd;
        String str1 = str.replace("=","");
        String token = request.getHeader("token");
        DecodedJWT verify = JwtUtils.verify(token);
        String id = verify.getClaim("id").asString();
        EncodingPwdUtils encodingPwdUtils = new EncodingPwdUtils();
        String apwd = accountService.selectPwd(id);
        boolean flag = encodingPwdUtils.pwd(str1, apwd);
        System.out.println("f:"+flag);
        return flag;
    }
    //账号表修改密码
    @RequestMapping(value = "updatePwd/{pwd}",method = RequestMethod.POST)
    public Integer updatePwd(@PathVariable("pwd") String pwd,HttpServletRequest request){
        String token = request.getHeader("token");
        DecodedJWT verify = JwtUtils.verify(token);
        String id = verify.getClaim("id").asString();
        EncodingPwdUtils encodingPwdUtils = new EncodingPwdUtils();
        String strpwd = encodingPwdUtils.encode(pwd);
        return accountService.updatePwd(strpwd,Integer.parseInt(id));
    }



}
