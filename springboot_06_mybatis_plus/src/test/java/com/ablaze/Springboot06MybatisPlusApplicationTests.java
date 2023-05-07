package com.ablaze;

import com.ablaze.dao.BookDao;
import com.ablaze.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot06MybatisPlusApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        System.out.println(bookDao.selectById(2));
    }

    @Test
    void testGetAll() {
        List<Book> bookList = bookDao.selectList(null);
        bookList.forEach(System.out::println);
    }

}
