package com.ayu.austin.receiver;

import com.alibaba.fastjson.JSON;
import com.ayu.austin.config.RabbitMqConfiguration;
import com.ayu.austin.domain.TaskInfo;
import com.ayu.austin.handler.SmsHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: aYu
 * @Date: 2022/7/28 10:17
 * @Description: 目前弃用
 */
@Slf4j
public class RabbitMQConsumer {

    @Autowired
    private SmsHandler smsHandler;

    @RabbitListener(queues = {RabbitMqConfiguration.QUEUE_AUSTIN})
    public void watchQueue(String payload, Message message) {

        String routingKey = message.getMessageProperties().getReceivedRoutingKey();
        log.info(routingKey);

        List<TaskInfo> lists = JSON.parseArray(payload, TaskInfo.class);
        for (TaskInfo taskInfo : lists) {
            smsHandler.doHandler(taskInfo);
        }
        log.info("receiver message:{}", JSON.toJSONString(lists));
    }
}
