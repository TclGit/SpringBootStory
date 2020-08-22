package com.aaa.security.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Component
public class LoginErrorHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        // 根据错误类型，返回不同的错误信息
        System.out.println(e.getClass());

        // 2.根据请求类型返回执行不同的操作
        boolean isAjax = false;

        // ajax请求，返回错误信息
        String accept = httpServletRequest.getHeader("Accept");
        String header = httpServletRequest.getHeader("X-Requested-With");
        if(accept.indexOf("application/json")!=-1){
            isAjax = true;
        }else if(header!=null && header.indexOf("XMLHttpRequest")!=-1){
            isAjax = true;
        }
        // 不是ajax请求，跳转错误页面
        if(isAjax){
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");

            HashMap<String, Object> map = new HashMap<>();
            map.put("code",500);
            map.put("message","用户名密码错误");
            String err = new ObjectMapper().writeValueAsString(map);
            httpServletResponse.getWriter().println(err);
        }else{
            httpServletResponse.sendRedirect("login.html");
        }
    }
}
