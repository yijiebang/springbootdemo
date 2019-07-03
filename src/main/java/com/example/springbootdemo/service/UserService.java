package com.example.springbootdemo.service;

import com.example.springbootdemo.dao.UserDao;
import com.example.springbootdemo.dao.UserJpa;
import com.example.springbootdemo.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {

    /**
     * mybtatis用法
     */
    @Autowired
    UserDao userDao;

    @Autowired
    private UserJpa userJpa; //使用jpa,不用可不加

    /**
     * 获取所有用户信息
     * @return
     */
    public List<User> getUsers(){
        return   userDao.getUsers();
    }


    /**
     * 使用jpa查询所有
     * @return
     */
    public List<User> queryList() {
        List<User> listUser =  userJpa.findAll();
        List<User> list = new ArrayList<>(  );
        Iterator<User> iterator = listUser.iterator();
        while (iterator.hasNext()) {
            User userEntity = iterator.next();
            User user = new User(  );
            BeanUtils.copyProperties( userEntity,user );
            list.add( user );
        }
        return list;
    }
    /**
     * 使用jpa根据name查询所有
     * @return
     */
    public List<User> queryNameList(String name) {
        List<User> listUser =  userJpa.findByName(name);
        List<User> list = new ArrayList<>(  );
        Iterator<User> iterator = listUser.iterator();
        while (iterator.hasNext()) {
            User userEntity = iterator.next();
            User user = new User(  );
            BeanUtils.copyProperties( userEntity,user );
            list.add( user );
        }
        return list;
    }

}
