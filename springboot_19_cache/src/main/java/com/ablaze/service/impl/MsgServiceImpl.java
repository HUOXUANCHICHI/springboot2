package com.ablaze.service.impl;

import com.ablaze.service.MsgService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author: ablaze
 * @Date: 2023/05/13/10:25
 */
@Service
public class MsgServiceImpl implements MsgService {

    private HashMap<String, String> cache = new HashMap<>();

    @Override
    public String get(String tele) {
        String code = tele.substring(tele.length() - 6);
        cache.put(tele, code);
        return code;
    }

    @Override
    public Boolean check(String tele, String code) {
        String queryCode = cache.get(tele);
        return code.equals(queryCode);
    }
}
