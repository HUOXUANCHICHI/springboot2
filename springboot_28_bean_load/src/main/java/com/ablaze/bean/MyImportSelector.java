package com.ablaze.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/22:05
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        try {
            Class<?> clazz = Class.forName("com.ablaze.bean.Mouse");

            if (clazz != null) {
                return new String[]{"com.ablaze.bean.Cat"};
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new String[0];
        }

        return null;
    }
}
