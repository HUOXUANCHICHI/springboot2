package com.ablaze.config;

import com.ablaze.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/10:15
 */
@Configuration(proxyBeanMethods = true)
public class SpringConfig33 {

    @Bean
    public Cat cat() {
        return new Cat();
    }
}
