package com.aaa.security;/*
 */

import com.aaa.security.processor.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import javax.annotation.Resource;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    AuthenticationErrorHandle authenticationErrorHandle;  //身份验证错误处理器

    @Resource
    AccessErrorHandle accessErrorHandle; //权限访问错误处理器

    @Resource
    LoginSuccessHandler loginSuccessHandler; //登录成功处理器

    @Resource
    LoginErrorHandler loginErrorHandler; //登录错误处理器

    @Resource
    JwtTokenFilter userJwtTokenFilter; //使用jwt代替Cokkie识别用户

    @Resource
    LogoutHandler logoutHandler; //退出处理器

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
            .and()
                .addFilterBefore(userJwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(authenticationErrorHandle)
                .accessDeniedHandler(accessErrorHandle)
            .and()
                .formLogin()
                .successHandler(loginSuccessHandler)
                .failureHandler(loginErrorHandler)
                .permitAll()
            .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutHandler)
                .permitAll()
            //.and()
                //注意：配置取消session管理,用Jwt来获取用户状态,否则即使token无效,也会有session信息,依旧判断用户为登录状态
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .authorizeRequests()
                .antMatchers("/utils/**").permitAll()
                .anyRequest()
                .access("@rbacConfig.isForbidden(request,authentication)")
            .and()
                .cors()
            .and()
                .csrf()
                .disable();

    }

    @Resource
    UserConfig userConfig;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userConfig);
        auth.authenticationProvider(daoAuthenticationProvider);
    }
}
