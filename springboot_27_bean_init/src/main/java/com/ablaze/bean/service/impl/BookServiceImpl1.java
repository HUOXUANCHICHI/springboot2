package com.ablaze.bean.service.impl;

import com.ablaze.bean.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @Author: ablaze
 * @Date: 2023/06/06/18:55
 */
@Service("bookService")
public class BookServiceImpl1 implements BookService {
    @Override
    public void check() {
        System.out.println("book service 1..");
    }
}
