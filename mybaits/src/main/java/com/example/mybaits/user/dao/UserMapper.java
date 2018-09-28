package com.example.mybaits.user.dao;

import com.example.mybaits.user.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    Integer insert(User user);

    List<User> queryByParams(Map params);

    Integer delById(Integer id);

    Integer update(User user);
}
