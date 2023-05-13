package com.ablaze.service;

/**
 * @Author: ablaze
 * @Date: 2023/05/13/10:24
 */
public interface MsgService {
    String get(String tele);

    Boolean check(String tele, String code);
}
