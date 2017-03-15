package com.mark.java.controller;

import com.mark.java.entity.User;
import com.mark.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lois on 2017/3/6.
 */

/**
 *controller的RequestMapping是"/"，index()的RequestMapping也是"/"，
 * 而方法json的RequestMapping是"/json"，
 * 也就是说，当访问的URL是”/“时，我们会调用index()方法处理，它返回的字符串是index，
 * 再根据配置文件中的路径，它指向的就是/webapp/pages下的index.jsp
 */

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("")

    public String home(){
        List<User> users = new ArrayList<User>();

        User u = new User();
        u.setUsername("Jessi");
//        u.setCellphone("13382513985");
        u.setPassword("12345");
        users.add(u);
        u = new User();
        u.setUsername("Liu");
        users.add(u);
//        userService.saveUsers(users);
        return "index";
    }

    @RequestMapping("/json")

    @ResponseBody
    public List<User> json(){
        return userService.getAllUsers();
    }
}

