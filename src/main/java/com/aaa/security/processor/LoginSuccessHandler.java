package com.aaa.security.processor;

import com.aaa.entity.Account;
import com.aaa.until.JsonUtils;
import com.aaa.until.JwtUtils;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        //登录的信息
        Account sysAccount = (Account)authentication.getPrincipal();

        Collection<? extends GrantedAuthority> authorities = sysAccount.getAuthorities();

        //封装信息
        HashMap<String, String> map = new HashMap<>();
        map.put("id",sysAccount.getAid().toString());
        map.put("username",sysAccount.getUsername());
        map.put("code", String.valueOf(HttpServletResponse.SC_OK));

        String token = JwtUtils.getToken(map);

        System.out.println("生成的TOKEN："+token);


        //fastJson
        String string = JSON.toJSONString(sysAccount);
        String res = JsonUtils.prettyJson(string);

        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        String str = new ObjectMapper().writeValueAsString(token);

        httpServletResponse.getWriter().println(str);
    }
}
