package com.yjb.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * （使用mybatis实现）用户表
 *  通过使用lombok无需加get set
 *  mybatis使用注解，实体类字段必须和数据库一致
 */
  @Entity
  @Data            // get set toString 等方法
  public class User implements Serializable {

    @Id             //主键
    @GeneratedValue //自增長
    private Integer  id;
    private String  name;
    private Integer age;
    private String  pwd;
    private String  idCard;//数据库使用的  _  配置中加了驼峰自动转，所以这里实体类可以使用驼峰命名

}