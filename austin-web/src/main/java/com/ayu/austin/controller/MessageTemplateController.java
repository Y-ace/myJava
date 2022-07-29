package com.ayu.austin.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.ayu.austin.dao.MessageTemplateDao;
import com.ayu.austin.domain.MessageTemplate;
import com.ayu.austin.enums.ChannelType;
import com.ayu.austin.enums.IdType;
import com.ayu.austin.enums.MessageType;
import com.ayu.austin.enums.TemplateType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: aYu
 * @Date: 2022/7/27 15:34
 * @Description:
 */

@Slf4j
@RestController
@RequestMapping("msgTemplate")
public class MessageTemplateController {

    @Autowired
    private MessageTemplateDao messageTemplateDao;

    /**
     * test insert
     */
    @GetMapping("/insert")
    public String insert() {

        /**
         * messageTemplate Id 为1 的模板内容
         * {"auditStatus":10,"auditor":"yyyyyyz","created":1636978066,"creator":"yyyyc","deduplicationTime":1,
         * "expectPushTime":"0","flowId":"yyyy","id":1,"idType":20,"isDeleted":0,"isNightShield":0,
         * "msgContent":"{\"content\":\"{$contentValue}\"}","msgStatus":10,"msgType":10,
         * "name":"test短信","proposer":"yyyy22","sendAccount":66,"sendChannel":30,
         * "team":"yyyt","templateType":10,"updated":1636978066,"updator":"yyyyu"}
         */
        MessageTemplate messageTemplate = MessageTemplate.builder()
                .name("test短信")
                .auditStatus(10)
                .flowId("ayu")
                .msgStatus(10)
                .id(1L)
                .idType(IdType.PHONE.getCode())
                .sendChannel(ChannelType.SMS.getCode())
                .templateType(TemplateType.OPERATION.getCode())
                .msgType(MessageType.AUTH_CODE.getCode())
                .expectPushTime("0")
                .msgContent("{\"content\":\"{$contentValue}\"}")
                .sendAccount(66)
                .creator("ayu")
                .updator("ayu")
                .team("ayu")
                .proposer("ayu")
                .auditor("ayu")
                .isDeleted(0)
                .created(Math.toIntExact(DateUtil.currentSeconds()))
                .updated(Math.toIntExact(DateUtil.currentSeconds()))
                .deduplicationTime(1)
                .isNightShield(0)
                .build();

        MessageTemplate info = messageTemplateDao.save(messageTemplate);

        return JSON.toJSONString(info);

    }

    /**
     * test query
     */
    @GetMapping("/query")
    public String query() {
        Iterable<MessageTemplate> all = messageTemplateDao.findAll();
        for (MessageTemplate messageTemplate : all) {
            return JSON.toJSONString(messageTemplate);
        }
        return null;
    }

}
