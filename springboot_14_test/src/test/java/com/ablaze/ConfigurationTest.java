package com.ablaze;

import com.ablaze.config.MsgConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @Author: ablaze
 * @Date: 2023/05/10/22:35
 */
@SpringBootTest
@Import(MsgConfig.class)
public class ConfigurationTest {

    @Autowired
    private String msg;

    @Test
    void testConfiguration() {
        System.out.println(msg);
    }
}
