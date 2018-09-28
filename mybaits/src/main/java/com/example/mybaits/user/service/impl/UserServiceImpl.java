package com.example.mybaits.user.service.impl;

import com.example.mybaits.user.dao.UserMapper;
import com.example.mybaits.user.model.User;
import com.example.mybaits.user.service.UserService;
import com.example.mybaits.util.ParamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
@CacheConfig(cacheNames = "users")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Override
    @CachePut(key = "#user.id")
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
//    @Cacheable( keyGenerator = "firstParamKeyGenerator")
    public List<User> queryByParams(User user) {

        Map params = ParamUtils.beanToMap(user);
        logger.info("queryByParams ,params:" + params.toString());
        return userMapper.queryByParams(params);
    }

    @Override
    @Cacheable(key = "#id")
    public User queryById(Integer id) {
        Map<String,Integer> params = new HashMap<>();
        params.put("id",id);
        List<User> users = userMapper.queryByParams(params);
        if (users == null || users.isEmpty())
            return null;
        return users.get(0);
    }


    @Override
    @CacheEvict(key = "#id")
    public int delById(Integer id) {
        return userMapper.delById(id);
    }

    @Override
    @CachePut(key = "#user.id")
    public int update(User user) {
        return userMapper.update(user);
    }
}
