package com.ablaze.config;

import com.ablaze.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/10:02
 */
@ComponentScan({"com.ablaze.bean","com.ablaze.config"})
public class SpringConfig3 {

    @Bean
    public DogFactoryBean dog() {
        return new DogFactoryBean();
    }
}
