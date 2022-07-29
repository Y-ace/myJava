package com.ayu.austin.controller;

import com.ayu.austin.domain.MessageParam;
import com.ayu.austin.domain.SendRequest;
import com.ayu.austin.domain.SendResponse;
import com.ayu.austin.enums.BusinessCode;
import com.ayu.austin.handler.SmsHandler;
import com.ayu.austin.service.SendService;
import com.ayu.austin.vo.BasicResultVO;
import com.ayu.austin.domain.TaskInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author: aYu
 * @Date: 2022/7/27 15:35
 * @Description:
 */
@RestController
@Slf4j
public class SendController {

    @Autowired
    private SendService sendService;

    @GetMapping("/sendSmsV2")
    public SendResponse sendSmsV2(String phone, Long templateId) {
        // 文案参数
        Map<String, String> variables = new HashMap<>();
        variables.put("contentValue", "6666");

        MessageParam messageParam = new MessageParam().setReceiver(phone).setVariables(variables);

        // ID为1的消息模板
        SendRequest sendRequest = new SendRequest().setCode(BusinessCode.COMMON_SEND.getCode())
                .setMessageTemplateId(templateId)
                .setMessageParam(messageParam);

        return sendService.send(sendRequest);
    }

}
