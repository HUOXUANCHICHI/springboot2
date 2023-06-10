package com.ablaze.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/9:56
 *
 */
//@Component
@Configuration
public class DbConfig {

    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        return ds;
    }
}
