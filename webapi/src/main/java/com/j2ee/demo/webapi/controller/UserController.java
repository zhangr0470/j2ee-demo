package com.j2ee.demo.webapi.controller;

/**
 * Created by rihaizhang on 2017/6/6.
 */

import com.j2ee.demo.webapi.dto.User;
import com.j2ee.demo.webapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {// Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public List<User> json() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String getUser(@RequestParam(value = "id") Integer id, @RequestParam(value = "name") String name) {

        ModelAndView view = new ModelAndView("users");
        List<User> users;
        User user = new User();
        user.setId(id);
        user.setName(name);
        userService.addUser(user);
        return "redirect:users";

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView users() {
        ModelAndView view = new ModelAndView("users");
        List<User> users = userService.getUsers();
        view.addObject("users", users);

        return view;
    }

}
