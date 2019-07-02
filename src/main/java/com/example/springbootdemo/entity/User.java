package com.example.springbootdemo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户表
 */
@Entity    //使用jpa,不用可不加
@Table(name = "user")//使用jpa,不用可不加
 public class User implements Serializable {


    @Id           //使用jpa,不用可不加
    @GeneratedValue//使用jpa,不用可不加
    private int id;
    private String name;
    private int age;
    private String pwd;
    private String idCard;
    //jpa：新加入的字段会和数据库进行比较，没有就会在数据库新增一个


    public User(){}
    public User(String name, int age, String pwd) {
        this.name = name;
        this.age = age;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}