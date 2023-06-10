package com.ablaze.bean;

import org.springframework.stereotype.Component;

/**
 * @Author: ablaze
 * @Date: 2023/06/06/18:54
 */
@Component("tom")
public class Cat {
    public Cat() {
    }

    int age;

    public Cat(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                '}';
    }
}
