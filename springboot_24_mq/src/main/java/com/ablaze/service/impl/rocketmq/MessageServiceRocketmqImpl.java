package com.ablaze.service.impl.rocketmq;

import com.ablaze.service.MessageService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: ablaze
 * @Date: 2023/06/06/14:53
 */
//@Service
public class MessageServiceRocketmqImpl implements MessageService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列(rocketmq),id:" + id);
        //同步
//        rocketMQTemplate.convertAndSend("order_id", id);
        //异步
        SendCallback callback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("消息发送失败!!!");

            }
        };
        rocketMQTemplate.asyncSend("order_id", id, callback);

    }

    @Override
    public String doMessage() {
        return null;
    }
}
