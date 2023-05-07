package com.ablaze.dao;

import com.ablaze.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: ablaze
 * @Date: 2023/05/07/10:48
 */
@Mapper
public interface BookDao {

    @Select("select * from tbl_book where id = #{id}")
    Book getById(Integer id);
}
