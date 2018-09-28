package com.example.mybaits.user.service;

import com.example.mybaits.user.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    int insert(User user);

    List<User> queryByParams(User user);

    User queryById(Integer id);

    int delById(Integer id);

    int update(User user);
}
