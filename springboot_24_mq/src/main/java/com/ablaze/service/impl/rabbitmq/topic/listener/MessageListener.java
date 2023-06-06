package com.ablaze.service.impl.rabbitmq.topic.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @Author: ablaze
 * @Date: 2023/05/17/15:50
 */
//@Component
public class MessageListener {
    @RabbitListener(queues = "topic_queue")
    public void receive(String id) {
        System.out.println("已完成短信发送业务(rabbitmq topic 1),id:" + id);
    }
    @RabbitListener(queues = "topic_queue2")
    public void receive2(String id) {
        System.out.println("已完成短信发送业务(rabbitmq topic 222222),id:" + id);
    }
}
