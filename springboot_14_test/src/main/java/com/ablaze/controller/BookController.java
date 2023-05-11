package com.ablaze.controller;

import com.ablaze.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ablaze
 * @Date: 2023/05/10/23:14
 */
@RestController
@RequestMapping("/books")
public class BookController {

/*
    @GetMapping
    public String getById() {
        System.out.println("getById is running...");
        return "springboot";
    }
*/

    @GetMapping
    public Book getById() {
        System.out.println("getById is running...");
        Book book = new Book();
        book.setId(1);
        book.setName("springboot");
        book.setType("springboot");
        book.setDescription("springboot");
        return book;
    }
}
