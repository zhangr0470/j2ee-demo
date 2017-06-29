package com.j2ee.demo.main;

import java.util.List;

/**
 * Created by rihai on 6/25/2017.
 */
public interface UserMapper {

    User selectUserByID(int id);
    List<User> getUsers();
    void addUser(User user);
    void updateUser(User user);
}

