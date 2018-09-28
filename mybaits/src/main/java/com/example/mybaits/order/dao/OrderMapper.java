package com.example.mybaits.order.dao;

import com.example.mybaits.order.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface OrderMapper {

    Integer insert(Order order);

    List<Order> queryByParams(Map params);

    Integer delById(Integer id);

    Integer update(Order order);
}
