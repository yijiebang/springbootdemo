package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController  {

    @Autowired
    UserService userService;



    @RequestMapping(value="/users")
    @ResponseBody
    public List<User> getUsers() {

        List<User> userList = userService.getUsers();

        return userList;

    }
}
