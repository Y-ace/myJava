package com.ayu.austin.pipeline;

/**
 * @Author: aYu
 * @Date: 2022/7/27 17:01
 * @Description: 业务执行器
 */
public interface BusinessProcess {

    /**
     * 真正处理逻辑
     * @param context
     */
    void process(ProcessContext context);

}
