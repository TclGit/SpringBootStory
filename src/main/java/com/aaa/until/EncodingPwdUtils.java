package com.aaa.until;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodingPwdUtils {

    public boolean pwd(String pwd,String apwd){
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();

        boolean flag = bcryptPasswordEncoder.matches(pwd,apwd);
        return flag;
    }

    public String encode(String str)
    {
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(str);
        return hashPass;
    }

    public static void main(String[] args) {
        EncodingPwdUtils encodingPwdUtils = new EncodingPwdUtils();
        boolean flag = encodingPwdUtils.pwd("123","$2a$10$TjwhHogLdTAKVRqA1Lvw1ueuaLd685RwrmT6MIRMyWOBn5gpLO4me");
        System.out.println(flag);

    }
}
