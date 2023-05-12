package com.ablaze.dao;

import com.ablaze.domain.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ablaze
 * @Date: 2023/05/11/12:23
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

}
