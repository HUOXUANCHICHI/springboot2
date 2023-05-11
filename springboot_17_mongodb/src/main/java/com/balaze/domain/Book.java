package com.balaze.domain;

import lombok.Data;

/**
 * @Author: ablaze
 * @Date: 2023/05/11/12:03
 */
@Data
public class Book {
    private Integer id;
    private String name;
    private String type;
    private String description;
}
