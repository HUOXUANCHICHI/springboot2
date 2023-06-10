package com.ablaze.config;

import com.ablaze.bean.MyPostProcessor;
import com.ablaze.bean.MyRegistrar;
import com.ablaze.bean.MyRegistrar2;
import com.ablaze.bean.service.impl.BookServiceImpl1;
import org.springframework.context.annotation.Import;

/**
 * @Author: ablaze
 * @Date: 2023/06/09/10:02
 */
@Import({BookServiceImpl1.class, MyRegistrar.class, MyRegistrar2.class, MyPostProcessor.class})
public class SpringConfig8 {

}
