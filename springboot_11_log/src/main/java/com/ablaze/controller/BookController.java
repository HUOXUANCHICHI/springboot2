package com.ablaze.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ablaze
 * @Date: 2023/05/04/17:27
 */
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController/* extends BaseClass*/ {

    //创建记录日志的对象
//    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public String getById() {
        System.out.println("springboot is running...");

        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");
        return "springboot is running...";
    }
}
