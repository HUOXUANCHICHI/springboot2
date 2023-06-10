package com.ablaze.config;

import com.ablaze.bean.Dog;
import org.springframework.context.annotation.Import;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/10:02
 */
@Import({Dog.class,DbConfig.class})
public class SpringConfig4 {

}
