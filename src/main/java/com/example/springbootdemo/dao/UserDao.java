package com.example.springbootdemo.dao;

import com.example.springbootdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Mapper
@Scope("prototype")
public interface UserDao{

    @Select(value = "select * from user")
    @Results(value = { @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
            @Result(column = "age", property = "age", jdbcType = JdbcType.INTEGER),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pwd", property = "pwd", jdbcType = JdbcType.VARCHAR) })
    List<User> getUsers();

}
