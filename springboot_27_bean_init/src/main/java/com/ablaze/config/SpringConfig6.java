package com.ablaze.config;

import com.ablaze.bean.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/10:02
 */
@Configuration
@ComponentScan(basePackages = "com.ablaze")
@Import({MyImportSelector.class})
public class SpringConfig6 {

}
