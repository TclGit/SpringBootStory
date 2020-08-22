package com.aaa.security.processor;/*
 */

import com.aaa.until.JwtUtils;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        HashMap<Object, Object> map = new HashMap<>();
        String token = request.getHeader("token");
        if(null == token || "".equals(token)){
            //第一次未带token
            chain.doFilter(request,response);
            return;
        }else{
            try {
                JwtUtils.verify(token.toString()); //验证令牌
                System.out.println("令牌验证成功");
                chain.doFilter(request,response);
                return;
            }catch (SignatureVerificationException e){
                e.printStackTrace();
                map.put("msg","无效签名");
                System.out.println("无效签名");
            }catch (TokenExpiredException e){
                e.printStackTrace();
                map.put("msg","token过期");
                System.out.println("token过期");
            }catch (AlgorithmMismatchException e){
                e.printStackTrace();
                map.put("msg","token算法不一致");
                System.out.println("token算法不一致");
            }catch (Exception e){
                e.printStackTrace();
                map.put("msg","无效的token");
                System.out.println("无效的token");
            }
            String res = new ObjectMapper().writeValueAsString(map);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println(res);
        }
    }
}
