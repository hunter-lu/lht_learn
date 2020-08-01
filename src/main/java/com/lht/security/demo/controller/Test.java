package com.lht.security.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：lht
 * @Date: 2020/5/21
 * @Desc:
 **/
@RestController
@Api(description = "test")
public class Test {

    @GetMapping("/")
    @ApiOperation(value = "test",notes = "test")
    public String test(){
        return "success!";
    }

    @GetMapping("/security")
    @ApiOperation(value = "hello",notes = "hello")
    public String security(){
        return "hello springboot security!";
    }

}
