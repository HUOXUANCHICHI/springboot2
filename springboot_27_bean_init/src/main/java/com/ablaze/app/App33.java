package com.ablaze.app;

import com.ablaze.config.SpringConfig33;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/10:15
 */
public class App33 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig33.class);

        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("----------------------");
        SpringConfig33 springConfig33 = ctx.getBean("springConfig33", SpringConfig33.class);
        System.out.println(springConfig33.cat());
        System.out.println(springConfig33.cat());
        System.out.println(springConfig33.cat());
    }
}
