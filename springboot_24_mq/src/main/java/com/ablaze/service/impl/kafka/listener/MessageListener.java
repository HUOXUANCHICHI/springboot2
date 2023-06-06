package com.ablaze.service.impl.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author: ablaze
 * @Date: 2023/06/06/15:55
 */
@Component
public class MessageListener {

    @KafkaListener(topics = "itheima2022")
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.println("已完成短信发送业务(kafka),id:" + record.value());

    }
}
