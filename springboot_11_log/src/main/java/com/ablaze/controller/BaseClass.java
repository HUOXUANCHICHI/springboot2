package com.ablaze.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: ablaze
 * @Date: 2023/05/08/23:37
 */
public class BaseClass {

    public final Logger log;

    public BaseClass() {
        Class<?> clazz = this.getClass();
        log = LoggerFactory.getLogger(clazz);
    }

}
