package com.ayu.austin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: aYu
 * @Date: 2022/7/27 16:55
 * @Description: 发送接口参数
 */
@Data
@Accessors(chain = true)
public class SendRequest {

    /**
     * 执行业务类型
     */
    private String code;

    /**
     * 消息模板Id
     */
    private Long messageTemplateId;

    /**
     * 消息相关参数
     */
    private MessageParam messageParam;

}
