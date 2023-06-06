package com.ablaze.service.impl.kafka;

import com.ablaze.service.MessageService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: ablaze
 * @Date: 2023/06/06/15:50
 */
@Service
public class MessageServiceKafkaImpl implements MessageService {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列(kafka),id:" + id);
        kafkaTemplate.send("itheima2022", id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
