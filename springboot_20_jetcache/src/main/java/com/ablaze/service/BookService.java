package com.ablaze.service;

import com.ablaze.domain.Book;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2023/05/11/12:24
 */
public interface BookService {
    Boolean save(Book book);

    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();

}
