package com.ablaze.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/22:50
 */
@ConfigurationProperties(prefix = "cartoon")
@Data
public class CartoonProperties {

    private Cat cat;
    private Mouse mouse;

}
