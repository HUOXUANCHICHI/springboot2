package com.ablaze.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @Author: ablaze
 * @Date: 2023/05/13/10:59
 */
@Component
public class CodeUtils {
    public String generator(String tele) {
        int hash = tele.hashCode();
        int encryption = 20206666;
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000;
        code = code < 0 ? -code : code;
        return String.format("%06d", code);

    }

    @Cacheable(value = "smsCode", key = "#tele")
    public String get(String tele) {
        return null;
    }
//    public static void main(String[] args) {
//        System.out.println(new CodeUtils().generator("193456123"));
//    }
}
