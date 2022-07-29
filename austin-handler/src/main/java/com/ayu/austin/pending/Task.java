package com.ayu.austin.pending;

import com.ayu.austin.domain.TaskInfo;
import com.ayu.austin.handler.HandlerHolder;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: aYu
 * @Date: 2022/7/28 15:57
 * @Description: Task 执行器
 *
 * 0.丢弃消息
 * 1.通用去重功能
 * 2.发送消息
 */
@Data
@Accessors(chain = true)
@Slf4j
public class Task implements Runnable {

    @Autowired
    private HandlerHolder handlerHolder;

    private TaskInfo taskInfo;

    @Override
    public void run() {

        // 0. TODO 丢弃消息

        // 1. TODO 通用去重

        // 2. 真正发送消息
        handlerHolder.route(taskInfo.getSendChannel())
                .doHandler(taskInfo);
    }
}
