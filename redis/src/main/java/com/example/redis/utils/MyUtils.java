package com.example.redis.utils;

import com.alibaba.druid.support.json.JSONUtils;

public class MyUtils {

    public static void main(String[] args) {
        User u = new User("  ");
        System.out.println(u.getName());
        String s = JSONUtils.toJSONString(u);
        System.out.println(s);
        User parse = (User)JSONUtils.parse(s);
        System.out.println(parse.getName());
    }

    static class User{
        private String name;

        public User() {
            super();
        }
        public User(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
