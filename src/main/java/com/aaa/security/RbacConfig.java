package com.aaa.security;/*
 */

import com.aaa.entity.Account;
import com.aaa.service.PromissionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("rbacConfig")
public class RbacConfig {


    @Resource
    PromissionService permissionService;


    public boolean isForbidden(HttpServletRequest request, Authentication authentication){
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails){
            Account sysAccount = (Account)authentication.getPrincipal();
            List<String> DatabaseUrl = permissionService.findPathByAccount(sysAccount.getAccount());
            for(String url : DatabaseUrl){
                if(url.equals(request.getRequestURI())){
                    return true;
                }
            }
        }
        return false;
    }

}
