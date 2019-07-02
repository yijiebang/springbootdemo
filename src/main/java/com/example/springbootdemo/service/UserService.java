package com.example.springbootdemo.service;

import com.example.springbootdemo.dao.UserDao;
import com.example.springbootdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    /**
     * 获取所有用户信息
     * @return
     */
    public List<User> getUsers(){
        return   userDao.getUsers();
    }

}
