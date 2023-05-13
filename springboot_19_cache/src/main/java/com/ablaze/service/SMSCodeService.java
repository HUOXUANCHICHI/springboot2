package com.ablaze.service;

import com.ablaze.domain.SMSCode;

/**
 * @Author: ablaze
 * @Date: 2023/05/13/10:55
 */
public interface SMSCodeService {
    String sendCodeToSMS(String tele);

    Boolean checkCode(SMSCode smsCode);
}
