package com.ablaze.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/16:56
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        System.out.println("提示:" + importingClassMetadata.getClassName());
//        System.out.println("===========");
//        System.out.println("提示:" + importingClassMetadata.hasAnnotation("org.springframework.context.annotation.Configuration"));
//        System.out.println("提示:" + importingClassMetadata.getAnnotationAttributes("org.springframework.context.annotation.ComponentScan"));
//        System.out.println("===========");

        //各种条件的判定，判定完毕后，决定是否装载指定的bean
        boolean flag = importingClassMetadata.hasAnnotation("org.springframework.context.annotation.Configuration");
        if (flag) {
            return new String[]{"com.ablaze.bean.Dog"};
        }
        return new String[]{"com.ablaze.bean.Cat"};
    }
}
