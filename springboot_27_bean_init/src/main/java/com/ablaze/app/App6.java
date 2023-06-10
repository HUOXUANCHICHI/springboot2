package com.ablaze.app;

import com.ablaze.config.SpringConfig6;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/10:15
 */
public class App6 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig6.class);

        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("------------------");
    }
}
