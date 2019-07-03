DROP DATABASE
IF
	EXISTS springboot;
CREATE DATABASE springboot;
USE springboot;


DROP TABLE IF EXISTS User;
	
	
CREATE TABLE User (
	 id  INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '编号',
	 name  VARCHAR ( 255 ) DEFAULT NULL COMMENT '用户名',
 	 age  INT ( 11 ) DEFAULT NULL COMMENT '年龄',
 	 pwd  VARCHAR ( 8 ) DEFAULT NULL COMMENT '密码',
	 id_Card  VARCHAR ( 18 ) DEFAULT NULL COMMENT '卡号',
	 PRIMARY KEY ( id ) 
);
 
	DELETE  FROM 	USER;
	
	INSERT INTO User (  name,  age, pwd, id_Card )
	VALUES
		(  '李四', 22, '123456', '430621111111' );
 