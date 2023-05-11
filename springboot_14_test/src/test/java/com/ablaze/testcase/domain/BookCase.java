package com.ablaze.testcase.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: ablaze
 * @Date: 2023/05/11/12:34
 */
@Component
@Data
@ConfigurationProperties(prefix = "testcase.book")
public class BookCase {

    private Integer id;
    private Integer id2;
    private Integer type;
    private String name;
    private String uuid;
    private Long publishTime;


}
