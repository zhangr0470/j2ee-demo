package com.j2ee.demo.webapi.service;

import com.j2ee.demo.webapi.dto.User;

import java.util.List;

/**
 * Created by rihai on 6/22/2017.
 */
public interface UserService {
    /**
     * 获取用户列表
     * @return 用户列表
     */
    List<User> getUsers();
}
