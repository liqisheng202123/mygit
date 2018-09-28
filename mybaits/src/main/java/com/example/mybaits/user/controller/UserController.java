package com.example.mybaits.user.controller;


import com.example.mybaits.user.model.User;
import com.example.mybaits.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @ResponseBody
    @RequestMapping("/add")
    public int add(User user){
        return userService.insert(user);
    }

    @RequestMapping("/query")
    public List<User> queryByParams(User user){
        return userService.queryByParams(user);
    }
    @RequestMapping("/del")
    public int delById(Integer id){
        return userService.delById(id);
    }
    @RequestMapping("/update")
    public int update(User user){
        return userService.update(user);
    }
}
