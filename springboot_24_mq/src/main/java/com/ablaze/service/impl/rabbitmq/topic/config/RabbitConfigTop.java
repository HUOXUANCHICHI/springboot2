package com.ablaze.service.impl.rabbitmq.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;

/**
 * @Author: ablaze
 * @Date: 2023/05/17/15:40
 */
//@Configuration
public class RabbitConfigTop {
    @Bean
    public Queue topicQueue() {
        return new Queue("topic_queue");
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue("topic_queue2");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindingTopic() {
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("topic.*.ids");
    }

    @Bean
    public Binding bindingTopic2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic2");
    }
}
