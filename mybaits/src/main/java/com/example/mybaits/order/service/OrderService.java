package com.example.mybaits.order.service;

import com.example.mybaits.order.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    Integer insert(Order order);

    List<Order> queryByParams(Order order);

    Integer delById(Integer id);

    Integer update(Order order);
}
