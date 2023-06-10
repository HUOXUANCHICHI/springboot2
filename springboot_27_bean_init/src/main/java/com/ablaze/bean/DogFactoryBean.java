package com.ablaze.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/10:07
 */
public class DogFactoryBean implements FactoryBean<Dog> {

    @Override
    public Dog getObject() throws Exception {
        Dog d = new Dog();
        //......
        return d;
    }

    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }

    @Override
    public boolean isSingleton() {
        //默认单例
        return FactoryBean.super.isSingleton();
    }
}
