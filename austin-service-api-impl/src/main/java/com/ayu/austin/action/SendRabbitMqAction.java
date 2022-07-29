package com.ayu.austin.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ayu.austin.config.RabbitMqConfiguration;
import com.ayu.austin.domain.SendTaskModel;
import com.ayu.austin.enums.ChannelType;
import com.ayu.austin.enums.RespStatusEnum;
import com.ayu.austin.pipeline.BusinessProcess;
import com.ayu.austin.pipeline.ProcessContext;
import com.ayu.austin.vo.BasicResultVO;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: aYu
 * @Date: 2022/7/28 10:06
 * @Description: RabbitMq
 */
@Slf4j
public class SendRabbitMqAction implements BusinessProcess {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void process(ProcessContext context) {
        SendTaskModel sendTaskModel = (SendTaskModel) context.getProcessModel();
        try {
            rabbitTemplate.convertAndSend(RabbitMqConfiguration.EXCHANGE_AUSTIN,
                    "austin." + ChannelType.SMS.getCode_en(), JSON.toJSONString(sendTaskModel.getTaskInfo(),
                            new SerializerFeature[] {SerializerFeature.WriteClassName}));
        } catch (Exception e) {
            context.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.SERVICE_ERROR));
            log.error("send rabbit fail! e:{},params:{}", Throwables.getStackTraceAsString(e)
                    , JSON.toJSONString(sendTaskModel.getTaskInfo().get(0)));
        }
    }
}
