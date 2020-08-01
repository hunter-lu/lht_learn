package com.lht.security.demo.service.impl;

import com.lht.security.demo.mapper.UserMapper;
import com.lht.security.demo.model.User;
import com.lht.security.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author：lht
 * @Date: 2020/5/23
 * @Desc:
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
