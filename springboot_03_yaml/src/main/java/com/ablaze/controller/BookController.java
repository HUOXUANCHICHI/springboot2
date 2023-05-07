package com.ablaze.controller;

import com.ablaze.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ablaze
 * @Date: 2023/05/05/11:33
 */
@RestController
@RequestMapping("/books")
public class BookController {

    //读取yaml数据中的单一数据
    @Value("${country}")
    private String country1;

    @Value("${user0.name}")
    private String name1;

    @Value("${likes[1]}")
    private String likes1;

    @Value("${users[1].age}")
    private String age1;

    @Value("${server.port}")
    private String port;

    @Value("${tempDir}")
    private String tempDir;

    //使用自动装配将所有的数据封装到一个对象Environment中
    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;

    @GetMapping
    public String getById(){
        System.out.println("springboot is running...");
        System.out.println("country1===>"+country1);
        System.out.println("name1===>"+name1);
        System.out.println("likes1===>"+likes1);
        System.out.println("age1===>"+age1);
        System.out.println("port===>"+port);
        System.out.println("tempDir===>"+tempDir);
        System.out.println("-----------------------------");
        System.out.println(env.getProperty("server.port"));
        System.out.println(env.getProperty("user0.name"));
        System.out.println("-----------------------------");
        System.out.println(myDataSource);
        return "springboot is running...";
    }

}
