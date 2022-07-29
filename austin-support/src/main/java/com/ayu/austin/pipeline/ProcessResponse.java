package com.ayu.austin.pipeline;

import lombok.Builder;


/**
 * @Author: aYu
 * @Date: 2022/7/27 17:00
 * @Description: 流程处理结果
 */
@Builder
public class ProcessResponse {

    /** 返回值编码 */
    private final String code;

    /** 返回值描述 */
    private final String description;
}
