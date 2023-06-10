package com.ablaze.app;

import com.ablaze.bean.service.BookService;
import com.ablaze.config.SpringConfig8;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/10:15
 */
public class App8 {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig8.class);

        BookService bookService = ctx.getBean("bookService", BookService.class);
        bookService.check();
    }
}
