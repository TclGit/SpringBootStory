package com.aaa.controller;

import com.aaa.service.PromissionService;
import com.aaa.until.JwtUtils;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("utils")
public class UtilsController {

    @Resource
    PromissionService promissionService;

    @RequestMapping("find")
    public Object find(HttpServletRequest request){
        String token = request.getHeader("token");

        DecodedJWT verify = JwtUtils.verify(token);
        String id = verify.getClaim("id").asString();

        List<Map<String, Object>> promiss = promissionService.findPromiss(Integer.parseInt(id));

        return promiss;
    }

}
