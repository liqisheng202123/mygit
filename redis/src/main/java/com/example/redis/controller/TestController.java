package com.example.redis.controller;

import com.example.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("/test")
    public String test(){
        redisUtil.set("LQS","GOOD");
        redisUtil.set("aaa","李启生");
        User user1 = new User(1,"tom");
        User user2 = new User(2,"李启生");
        redisUtil.set(String.valueOf(user1.getId()),user1);
        redisUtil.set(String.valueOf(user2.getId()),user2);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        redisUtil.hset("users","test",list);
        return "OD";
    }
    @RequestMapping(value = "/first")
    public Map<String, Object> firstResp (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("request Url", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return map;
    }

    @RequestMapping(value = "/sessions")
    public Object sessions (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("map"));
        return map;
    }

    @RequestMapping("/testGet")
    public String testGet(){
        return (String)redisUtil.get("LQS");
    }


    class User{
        private int id;
        private String name;
        public User(){}
        public User(int id,String name){
            this.id = id;
            this.name = name;
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
    }
}
