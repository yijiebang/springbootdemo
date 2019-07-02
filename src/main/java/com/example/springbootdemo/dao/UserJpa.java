package com.example.springbootdemo.dao;

import com.example.springbootdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * jpa的类，默认使用自带的方法
 * 使用jpa,不用可不加
 */
public interface UserJpa extends JpaRepository<User,Integer> {
}
