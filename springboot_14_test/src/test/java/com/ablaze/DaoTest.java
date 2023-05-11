package com.ablaze;

import com.ablaze.domain.Book;
import com.ablaze.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: ablaze
 * @Date: 2023/05/11/12:26
 */
@SpringBootTest
@Transactional
@Rollback(value = true)
public class DaoTest {

    @Autowired
    private BookService bookService;

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("springboot");
        book.setType("springboot");
        book.setDescription("springboot");

        bookService.save(book);

    }
}
