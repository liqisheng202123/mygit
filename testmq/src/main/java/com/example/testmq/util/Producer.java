package com.example.testmq.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.print.attribute.standard.Destination;

@Service("producer")
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    public void sendMessage(String destinationName,final String message){
        jmsMessagingTemplate.convertAndSend(destinationName,message);
    }
}
