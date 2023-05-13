package com.ablaze.service.impl;

import com.ablaze.domain.SMSCode;
import com.ablaze.service.SMSCodeService;
import com.ablaze.utils.CodeUtils;
import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ablaze
 * @Date: 2023/05/13/10:56
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;
    //remote
//    @CreateCache(area="sms",name="jetCache_",expire = 10,timeUnit = TimeUnit.SECONDS)

    @CreateCache(name = "jetCache_", expire = 1000, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.LOCAL)
    private Cache<String, String> jetCache;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        jetCache.put(tele, code);
        return code;
    }

    @Override
    public Boolean checkCode(SMSCode smsCode) {
        //取出内存中的验证码与传递过来的验证码比对，如果相同，返回true
        String code = jetCache.get(smsCode.getTele());
        return smsCode.getCode().equals(code);
    }


}
