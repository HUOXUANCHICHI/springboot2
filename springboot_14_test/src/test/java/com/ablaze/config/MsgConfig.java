package com.ablaze.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ablaze
 * @Date: 2023/05/10/22:27
 */
@Configuration
public class MsgConfig {

    @Bean
    public String msg() {
        return "bean msg";
    }
}
