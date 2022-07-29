package com.ayu.austin.handler;

import com.ayu.austin.domain.TaskInfo;
import com.ayu.austin.enums.ChannelType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @Author: aYu
 * @Date: 2022/7/27 15:01
 * @Description: 发送各个渠道的handler
 */
public abstract class Handler {

    /**
     * 标识渠道的Code
     * 子类初始化的时候指定
     */
    protected Integer channelCode;


    @Autowired
    private HandlerHolder handlerHolder;

    /**
     * 初始化渠道与Handler的映射关系
     */
    @PostConstruct
    private void init() {
        for (ChannelType channelType : ChannelType.values()) {
            handlerHolder.putHandler(channelType.getCode(), this);
        }
    }

    public void doHandler(TaskInfo taskInfo) {
        handler(taskInfo);
    }

    /**
     * 统一处理的handler接口
     *
     * @param taskInfo
     * @return
     */
    public abstract void handler(TaskInfo taskInfo);

}