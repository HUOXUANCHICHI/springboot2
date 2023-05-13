package com.ablaze.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: ablaze
 * @Date: 2023/05/11/12:03
 */
@Data
public class Book implements Serializable {
    private Integer id;
    private String name;
    private String type;
    private String description;
}
