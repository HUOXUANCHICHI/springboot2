package com.ablaze.controller;

import com.ablaze.domain.Book;
import com.ablaze.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }



    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }


}

















