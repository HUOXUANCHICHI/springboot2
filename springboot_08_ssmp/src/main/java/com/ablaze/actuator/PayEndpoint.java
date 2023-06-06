package com.ablaze.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @Author: ablaze
 * @Date: 2023/06/06/17:57
 */
@Component
@Endpoint(id = "pay", enableByDefault = true)
public class PayEndpoint {

    @ReadOperation
    public Object getPay() {
        System.out.println("=============");
        System.out.println("=====pay=====");
        System.out.println("=============");
        HashMap<String, String> payMap = new HashMap<>();
        payMap.put("level 1", "300");
        payMap.put("level 2", "301");
        payMap.put("level 3", "304");
        return payMap;
    }
}
