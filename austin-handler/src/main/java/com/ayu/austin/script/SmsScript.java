package com.ayu.austin.script;

import com.ayu.austin.domain.SmsRecord;
import com.ayu.austin.domain.SmsParam;

import java.util.List;

/**
 * @Author: aYu
 * @Date: 2022/7/27 15:04
 * @Description: 短信通用接口
 */
public interface SmsScript {

    /**
     * @param smsParam 发送短信参数
     * @return 渠道商接口返回值
     */
    List<SmsRecord> send(SmsParam smsParam);

}
