package com.aaa.controller;

import com.aaa.entity.Account;
import com.aaa.entity.Employee;
import com.aaa.entity.Role;
import com.aaa.service.EmpService;
import com.aaa.service.PromissionService;
import com.aaa.service.RoleService;
import com.aaa.service.impl.AccountService;
import com.aaa.until.JwtUtils;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.ui.Model;
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
     * 马琳  账号增删改
     */
    @Resource
    AccountService accountService;

    @ResponseBody
    @RequestMapping("ListAll")
    public Object list(Model model){
        List<Account> accounts = accountService.ListAll();
        return accounts;
    }

    @ResponseBody
    @RequestMapping("insert")
    public Object insert(@RequestBody Account account){
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
}
