package com.lht.security.demo.service;

import com.lht.security.demo.model.User;

/**
 * @Author：lht
 * @Date: 2020/5/23
 * @Desc:
 **/
public interface UserService {

    User findByUsername(String username);

}
