package com.ablaze.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.stereotype.Component;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/22:01
 */
@Component("tom")
@ConditionalOnBean(name = "jerry")
@ConditionalOnNotWebApplication
public class Cat {
}
