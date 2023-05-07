package com.ablaze.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ablaze
 * @Date: 2023/05/07/10:52
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Integer id;
    private String type;
    private String name;
    private String description;

}
