package com.example.mybaits.order.controller;

import com.example.mybaits.order.model.Order;
import com.example.mybaits.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/add")
    public int add(Order order){
        return orderService.insert(order);
    }

    @RequestMapping("/query")
    public List<Order> queryByParams(Order order){
        return orderService.queryByParams(order);
    }
    @RequestMapping("/del")
    public int delById(Integer id){
        return orderService.delById(id);
    }
    @RequestMapping("/update")
    public int update(Order order){
        return orderService.update(order);
    }
}
