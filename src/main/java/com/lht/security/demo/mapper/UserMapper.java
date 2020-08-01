package com.lht.security.demo.mapper;

import com.lht.security.demo.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author：lht
 * @Date: 2020/5/23
 * @Desc:
 **/
public interface UserMapper {

    /**
     * 查询user
     * @param username
     * @return
     */
    User findByUsername(@Param("username") String username);


}
