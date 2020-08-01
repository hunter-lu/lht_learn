package com.lht.security.demo.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author：lht
 * @Date: 2020/5/23
 * @Desc:
 **/
@Data
public class Role {

    private Integer rid;

    private String name;

    private Set<Permission> permissions = new HashSet<>();

    private Set<User> users = new HashSet<>();

}
