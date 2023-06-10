package com.ablaze.app;

import com.ablaze.bean.Dog;
import com.ablaze.config.SpringConfig4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/10:15
 */

public class App4 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig4.class);

        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("------------------");
        System.out.println(ctx.getBean(Dog.class));
    }
}
