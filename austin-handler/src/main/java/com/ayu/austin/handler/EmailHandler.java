package com.ayu.austin.handler;

import com.ayu.austin.domain.TaskInfo;
import com.ayu.austin.enums.ChannelType;
import org.springframework.stereotype.Component;

/**
 * @Author: aYu
 * @Date: 2022/7/28 15:54
 * @Description: 邮件发送处理
 */
@Component
public class EmailHandler extends Handler {

    public EmailHandler() {
        channelCode = ChannelType.EMAIL.getCode();
    }


    @Override
    public void handler(TaskInfo taskInfoList) {
    }
}
