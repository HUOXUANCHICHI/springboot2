package com.ablaze.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @Author: ablaze
 * @Date: 2023/05/17/13:59
 */
//@Component
public class MessageListener {
    @JmsListener(destination = "order.queue.id")
    @SendTo("order.other.queue.id")
    public String receive(String id) {
        System.out.println("已完成短信发送业务,id:" + id);
        return "new:" + id;
    }
}
