package com.example.mybaits.order.model;

import java.math.BigDecimal;

public class Order {
    /**
     * 订单ID
     */
    private Integer id;

    /**
     * 客户ID
     */
    private Integer userId;

    /**
     * 订单名称
     */
    private String orderName;

    /**
     * 订单金额
     */
    private BigDecimal money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
