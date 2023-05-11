package com.ablaze;

import com.ablaze.dao.BookDao;
import com.ablaze.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootTest
class Springboot15SqlApplicationTests {

    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        bookDao.selectById(1);
    }

    @Test
    void testJdbcTemplate(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "select * from tbl_book";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//        maps.forEach(System.out::println);
        List<Book> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Book temp = new Book();
            temp.setId(rs.getInt("id"));
            temp.setName(rs.getString("name"));
            temp.setType(rs.getString("type"));
            temp.setDescription(rs.getString("description"));
            return temp;
        });
        list.forEach(System.out::println);
    }

    @Test
    void testJdbcTemplateSave(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "insert into tbl_book VALUES (2, '1','12','1')";
        jdbcTemplate.update(sql);
    }
}
