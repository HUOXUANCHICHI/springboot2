package com.ablaze;

import com.ablaze.dao.BookDao;
import com.ablaze.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05MybatisApplicationTests {


    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        Book byId = bookDao.getById(1);
        System.out.println(byId);
    }

}
