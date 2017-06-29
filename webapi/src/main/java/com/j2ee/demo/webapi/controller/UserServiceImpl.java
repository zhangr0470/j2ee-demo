package com.j2ee.demo.webapi.controller;

import com.j2ee.demo.webapi.dto.User;
import com.j2ee.demo.webapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rihai on 6/22/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        User user = new User();
        user.setId(1);
        user.setName("hai");
        users.add(user);
        User user2 = new User();
        user2.setId(2);
        user2.setName("jack");
        users.add(user2);
        return users;
    }
}
