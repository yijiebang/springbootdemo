package com.yjb.controller;

import com.yjb.config.JsonResult;
import com.yjb.entity.User;
import com.yjb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController  {
    protected static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/logtest")
    public JsonResult Test(@RequestParam(value = "role") Integer role) throws Exception {
            logger.info("访问了controller");

                 //Exception异常会自动拦截，这里只是做个测试自定义异常

            return new JsonResult(200, "成功", new HashMap<>(0));

    }

    /***
     * 查询所有用户
     * http://localhost:8080/user/getUsers
     * @return
     */
    @RequestMapping(value="/getUsers")
    public List<User> findAll() {
        logger.info("访问了controller,查询所有");
        List<User> userList = userService.findAll();
        return userList;
    }

    /**
     * @Description:根据用户ID查找用户
     * 访问地址：http://localhost:8080/user/findById?id=1
     * @param id
     */
    @RequestMapping("/findById")
    public User findById(@RequestParam("id") int id) {

        logger.info("访问了controller,根据用户id查询用户");
        User user = userService.findById(id);
        System.out.println("用户:"+user.toString());
        return user;
    }
    /**
     * @Description:新增用户
     * 访问地址：http://localhost:8080/user/insert?name=2&age=1&pwd=123456&idcard=122112
     * @param name
     */
    @RequestMapping("/insert")
    public String insert(  @RequestParam("name")  String name,
                         @RequestParam("age")   Integer age,
                         @RequestParam("pwd")  String pwd,
                         @RequestParam("idcard")  String idcard) {
        System.out.println("新增用户");
        User user=new User();
        user.setName(name);
        user.setAge(age);
        user.setIdCard(idcard);
        user.setPwd(pwd);
        int result = userService.insert(user);
        if(result==1) {
            System.out.println("新增成功");
            return "success";
        }else {
            System.out.println("新增失败");
            return "error";
        }
    }
    /**
     * @Description:修改用户
     * 访问地址：http://localhost:8080/user/update?id=2&name=3
     */
    @RequestMapping("/update")
    public String update(@RequestParam("id") int id,@RequestParam("name") String name) {
        System.out.println("修改用户");
        User user = new User();
        user.setId(id);
        user.setName(name);
        System.out.println(user);
        int result = userService.update(user);
        if(result==1) {
            System.out.println("修改成功");
            return "success";
        }else {
            System.out.println("修改失败");
            return "error";
        }
    }

    /**
     * @Description:根据用户ID修改用户
     * 访问地址：http://localhost:8080/user/delete?id=2
     * @param id
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        System.out.println("删除用户");
        int result = userService.delete(id);
        if(result==1) {
            System.out.println("删除成功");
            return "success";
        }else {
            System.out.println("删除失败");
            return "error";
        }
    }
}
