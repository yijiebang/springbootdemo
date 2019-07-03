package com.example.springbootdemo.dao;

import com.example.springbootdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * jpa的类，默认使用自带的方法
 * 使用jpa,不用可不加
 */
public interface UserJpa extends JpaRepository<User,Integer> {



    @Query(value="select o from User o where o.name like %:nn")
    public List<User> findByName(@Param("nn") String name);
}
