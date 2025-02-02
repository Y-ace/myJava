package com.ayu.austin.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @Author: aYu
 * @Date: 2022/7/27 19:22
 * @Description: 消息参数
 */
@Data
@Accessors(chain = true)
public class MessageParam {

    /**
     * @Description: 接收者
     * 多个用,逗号号分隔开
     * 必传
     */
    private String receiver;

    /**
     * @Description: 消息内容中的可变部分
     * 可选
     */
    private Map<String, String> variables;

    /**
     * @Description: 扩展参数
     * 可选
     */
    private Map<String,String> extra;
}
