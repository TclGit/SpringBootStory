package com.aaa.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Date;

/**
 * (Account)实体类
 *
 * @author makejava
 * @since 2020-08-21 20:06:29
 */
@Data
public class Account implements UserDetails {

    private Integer aid;

    private String account;

    private String pwd;

    private Date createtime;

    private Integer enable;

    private Integer isaccountnonexpired;

    private Integer isaccountnonlocked;

    private Integer iscredentialsnonexpired;

    private Integer isenabled;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.pwd;
    }

    @Override
    public String getUsername() {
        return this.account;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isaccountnonexpired == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isaccountnonlocked == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.iscredentialsnonexpired == 1;
    }

    @Override
    public boolean isEnabled() {
        return this.enable == 1;
    }
}