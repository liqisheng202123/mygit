package com.example.testmq.util;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "mytest")
    public void receive(String message){
        System.out.println("收到"+message);
    }
}
