package com.ablaze.controller;


import com.ablaze.controller.utils.R;
import com.ablaze.domain.Book;
import com.ablaze.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @Author: ablaze
 * @Date: 2023/05/07/13:02
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public R getAll() {
        return new R(true, bookService.getAll());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
//        R r = new R();
//        boolean flag = bookService.save(book);
//        r.setFlag(flag);
        if ("123".equals(book.getName())) {
            throw new IOException();
        }
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book) throws IOException {
        if ("123".equals(book.getName())) {
            throw new IOException();
        }
        boolean flag = bookService.update(book);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }


}
