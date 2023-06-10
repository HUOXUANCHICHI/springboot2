package com.ablaze.bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @Author: ablaze
 * @Date: 2023/06/06/18:59
 */
@SpringBootApplication
@Import(CartoonCatAndMouse.class)
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class);
        CartoonCatAndMouse bean = ctx.getBean(CartoonCatAndMouse.class);
        bean.play();

    }
}
