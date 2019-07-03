package com.yjb.service;

import com.yjb.entity.User;
import com.yjb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

    @Autowired
    UserMapper userMapper;


     public List<User> findAll() {
        return userMapper.findAll();
    }

     public User findById(int id) {
        return userMapper.findById(id);
    }

     public int insert(User user) {
        return userMapper.insert(user);
    }

     public int update(User user) {
        return userMapper.update(user);
    }

     public int delete(int id) {
        return userMapper.delete(id);
    }
}
