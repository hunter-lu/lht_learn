package com.lht.security.demo.controller;

import com.lht.security.demo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author：lht
 * @Date: 2020/5/21
 * @Desc:
 **/
@RestController
@Api("security")
@Slf4j
public class SecurityController {


    @ApiOperation(value = "login",notes = "shiro login")
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password")String password){
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(usernamePasswordToken);
            User user = (User) subject.getPrincipal();
        }catch (AuthenticationException e){
            log.error("login failure:" + e);
            return "login failure!";
        }
        return "login success!";

    }

}
