package com.yjb.mapper;

import com.yjb.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Scope;

import java.util.List;

/***
 * 使用mybatis注解实现增删改查
 */
@Mapper
@Scope("prototype")
public interface UserMapper {


    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") int id);

    @Insert("insert into user(name,age,pwd,id_Card) values(#{name},#{age},#{pwd},#{idCard})")
    int insert(User user);

    @Update("update user set name=#{name} where id=#{id}")
    int update(User user);

    @Delete("delete from user where id=#{id}")
    int delete(int id);
}
