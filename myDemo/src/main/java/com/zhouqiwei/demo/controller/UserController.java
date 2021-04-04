package com.zhouqiwei.demo.controller;

import com.zhouqiwei.demo.domain.User;
import com.zhouqiwei.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping(path="/user")

public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping(path="/login")
    public String login(String name,String password){
        User user=userMapper.selectUser(name);
        if(Objects.equals(password,user.getPassword())){
            return "登陆成功";
        }
        return "登录失败";
    }
    @GetMapping("register")
    public String register(String name,String password){
        log.info("name:{}",name);
        log.info("password:{}",password);
        int resultCount=userMapper.saveUser(name,password);
        //用户名不为空 密码不为空
        if(StringUtils.isEmpty(name)){
            return "用户名不能为空";
        }
        if(StringUtils.isEmpty(password)){
            return "密码不能为空";
        }
        //未储存成功,返回的数字为0
       if(resultCount==0){
            return "注册失败";
        }
        return "注册成功";
    }
}
