package com.ablaze.service.impl;

import com.ablaze.dao.BookDao;
import com.ablaze.domain.Book;
import com.ablaze.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ablaze
 * @Date: 2023/05/11/12:25
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }
}
