package com.ablaze.dao.impl;

import com.ablaze.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @Author: ablaze
 * @Date: 2023/05/07/10:22
 */

@Repository
public class BookDaoImpl implements BookDao {

    @Override
    public void save() {
        System.out.println("book dao is running...");
    }
}
