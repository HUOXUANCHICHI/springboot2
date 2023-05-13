package com.ablaze.service.impl;

import com.ablaze.dao.BookDao;
import com.ablaze.domain.Book;
import com.ablaze.service.BookService;
import com.alicp.jetcache.anno.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2023/05/11/12:25
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    @Cached(name = "book_", key = "#id", expire = 3600,cacheType = CacheType.REMOTE)
//    @CacheRefresh(refresh = 5)
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    @CacheUpdate(name = "book_", key = "#book.id", value = "#book")
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    @CacheInvalidate(name = "book_", key = "#id")
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }


    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

}
