package com.j2ee.demo.webapi.service;

import com.j2ee.demo.main.UserMapper;
import com.j2ee.demo.webapi.dto.User;
import com.j2ee.demo.webapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rihai on 6/22/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        List<com.j2ee.demo.main.User> users2 = userMapper.getUsers();
        for(com.j2ee.demo.main.User u2: users2){
            User user = new User();
            user.setId(u2.getId());
            user.setName(u2.getUserName());
            user.setCreateTime(u2.getCreateDate());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setDateStr(formatter.format(u2.getCreateDate()));
            users.add(user);
        }
        return users;
    }

    public void addUser(User user) {
        com.j2ee.demo.main.User u2= new com.j2ee.demo.main.User();
        u2.setUserName(user.getName());
        u2.setCreateDate(new Date());
        userMapper.addUser(u2);
    }
}
