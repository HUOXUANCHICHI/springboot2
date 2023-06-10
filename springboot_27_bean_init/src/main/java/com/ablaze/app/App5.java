package com.ablaze.app;

import com.ablaze.bean.Cat;
import com.ablaze.bean.Mouse;
import com.ablaze.config.SpringConfig4;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/10:15
 */

public class App5 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig4.class);
        //上下文容器对象已经初始化完毕后，手工加载bean
        ctx.registerBean("tom", Cat.class,0);
        ctx.registerBean("tom", Cat.class,1);
        ctx.registerBean("tom", Cat.class,2);
        ctx.register(Mouse.class);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("------------------");
        System.out.println(ctx.getBean(Cat.class));
    }
}
