package com.lht.security.demo.shiro;

import com.lht.security.demo.model.Permission;
import com.lht.security.demo.model.Role;
import com.lht.security.demo.model.User;
import com.lht.security.demo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Author：lht
 * @Date: 2020/5/23
 * @Desc:
 **/
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        User us = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList = new ArrayList<>();
        Set<Role> roleSet = us.getRoles();
        if(!CollectionUtils.isEmpty(roleSet)){
            for(Role role : roleSet){
                Set<Permission> permissionSet = role.getPermissions();
                if(!CollectionUtils.isEmpty(permissionSet)){
                    for(Permission permission : permissionSet){
                        permissionList.add(permission.getName());
                    }
                }
            }
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        return info;
    }

    //登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        User user = userService.findByUsername(username);
        if(user != null){
            return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
        }
        return null;
    }
}
