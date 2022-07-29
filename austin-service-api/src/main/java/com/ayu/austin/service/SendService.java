package com.ayu.austin.service;

import com.ayu.austin.domain.BatchSendRequest;
import com.ayu.austin.domain.SendRequest;
import com.ayu.austin.domain.SendResponse;

/**
 * @Author: aYu
 * @Date: 2022/7/27 16:57
 * @Description: 发送接口
 */
public interface SendService {

    /**
     * 单文案发送接口
     * @param sendRequest
     * @return
     */
    SendResponse send(SendRequest sendRequest);


    /**
     * 多文案发送接口
     * @param batchSendRequest
     * @return
     */
    SendResponse batchSend(BatchSendRequest batchSendRequest);

}
