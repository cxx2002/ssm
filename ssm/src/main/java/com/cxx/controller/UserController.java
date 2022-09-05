package com.cxx.controller;

import com.cxx.pojo.User;
import com.cxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 陈喜喜
 * @date 2022-08-02 22:15
 */
@CrossOrigin  //在服务器端允许跨域访问
@Controller
@RequestMapping(value = "/user")
public class UserController {
    //切记：Controller层一定有Service层的对象
    @Autowired
    UserService userService;

    public static final int PAGE_SIZE = 5;

    //url: /user/ selectUserPage?userName=z&userSex=男&page=null
    @RequestMapping("/selectUserPage")
    @ResponseBody
    public List<User> selectUserPage(String userName, String userSex, Integer page) {
        //根据页码计算起始行
        int startRow = 0;
        if (page != null) {
            startRow = PAGE_SIZE*(page - 1);
        }
        return userService.selectUserPage(userName,userSex,startRow);
    }

    //url /user/getRowCount?userName=&userSex=男
    @RequestMapping("/getRowCount")
    @ResponseBody
    public int getRowCount(String userName, String userSex) {
        return userService.getRowCount(userName, userSex);
    }

    //url /user/deleteUserById?userId=15968162087363060
    @RequestMapping("/deleteUserById")
    @ResponseBody
    public int deleteUserById(String userId) {
        return userService.deleteUserById(userId);
    }

    //url /user/createUser
    @RequestMapping("/createUser")
    @ResponseBody
    public int createUser(User user) {
        String userId = System.currentTimeMillis() + "";
        user.setUserId(userId);
        return userService.createUser(user);
    }
}
