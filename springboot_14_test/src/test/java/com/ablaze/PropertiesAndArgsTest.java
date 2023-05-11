package com.ablaze;

import com.ablaze.testcase.domain.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: ablaze
 * @Date: 2023/05/10/22:12
 */
//properties属性可以为当前测试用例添加临时的属性配置
//@SpringBootTest(properties = {"test.prop=testValue1"})
//@SpringBootTest(args = {"--test.prop=testValue2"})
@SpringBootTest(properties = {"test.prop=testValue1"}, args = {"--test.prop=testValue2"})
public class PropertiesAndArgsTest {

    @Value("${test.prop}")
    private String msg;

    @Autowired
    private BookCase bookCase;

    @Test
    void testProperties() {
        System.out.println(msg);
        System.out.println(bookCase);
    }
}
