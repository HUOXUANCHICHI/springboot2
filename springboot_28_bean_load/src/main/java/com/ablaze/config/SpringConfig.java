package com.ablaze.config;

import com.ablaze.bean.Cat;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/22:03
 */
//@Import(MyImportSelector.class)
//@Import(Mouse.class)
@ComponentScan("com.ablaze.bean")
public class SpringConfig {

    @Bean
//    @ConditionalOnClass(name = "com.ablaze.bean.Mouse")
//    @ConditionalOnMissingClass("com.ablaze.bean.Wolf")
//    @ConditionalOnBean(name = "jerry")
//    @ConditionalOnMissingClass("com.ablaze.bean.Dog")
//    @ConditionalOnNotWebApplication
//    @ConditionalOnWebApplication
    public Cat tom() {
        return new Cat();
    }

    @Bean
    @ConditionalOnClass(name = "com.mysql.jdbc.Driver")
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }
}
