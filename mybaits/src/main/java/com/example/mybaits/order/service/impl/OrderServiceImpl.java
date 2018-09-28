package com.example.mybaits.order.service.impl;

import com.example.mybaits.order.dao.OrderMapper;
import com.example.mybaits.order.model.Order;
import com.example.mybaits.order.service.OrderService;
import com.example.mybaits.util.ParamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Integer insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public List<Order> queryByParams(Order order) {
        Map<String, Object> params = ParamUtils.beanToMap(order);
        return orderMapper.queryByParams(params);
    }

    @Override
    public Integer delById(Integer id) {
        return orderMapper.delById(id);
    }

    @Override
    public Integer update(Order order) {
        return orderMapper.update(order);
    }
}
