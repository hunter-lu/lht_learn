package com.lht.security.demo.model;

import lombok.Data;

import javax.lang.model.type.IntersectionType;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author：lht
 * @Date: 2020/5/23
 * @Desc:
 **/
@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private Set<Role> roles = new HashSet<>();

}
