package com.ayu.austin.utils;

import cn.hutool.core.date.DateUtil;
import com.ayu.austin.constant.AustinConstant;

import java.util.Date;

/**
 * @Author: aYu
 * @Date: 2022/7/27 20:47
 * @Description: 生成 消息推送的URL 工具类
 */
public class TaskInfoUtils {

    private static int TYPE_FLAG = 1000000;

    /**
     * 生成BusinessId
     * 模板类型+模板ID+当天日期
     * (固定16位)
     */
    public static Long generateBusinessId(Long templateId, Integer templateType) {
        Integer today = Integer.valueOf(DateUtil.format(new Date(),  AustinConstant.YYYYMMDD));
        return Long.valueOf(String.format("%d%s", templateType * TYPE_FLAG + templateId, today));
    }

}