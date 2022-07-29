package com.ayu.austin.handler;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.ayu.austin.dao.SmsRecordDao;
import com.ayu.austin.domain.SmsRecord;
import com.ayu.austin.domain.SmsParam;
import com.ayu.austin.domain.TaskInfo;
import com.ayu.austin.dto.SmsContentModel;
import com.ayu.austin.enums.ChannelType;
import com.ayu.austin.script.SmsScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: aYu
 * @Date: 2022/7/27 15:27
 * @Description:
 */
@Component
public class SmsHandler extends Handler{

    @Autowired
    private SmsRecordDao smsRecordDao;

    @Autowired
    private SmsScript smsScript;

    public SmsHandler() {
        channelCode = ChannelType.SMS.getCode();
    }


    @Override
    public void handler(TaskInfo taskInfo) {

        SmsParam smsParam = SmsParam.builder()
                .phones(taskInfo.getReceiver())
                .content(getSmsContent(taskInfo))
                .messageTemplateId(taskInfo.getMessageTemplateId())
                .supplierId(10)
                .supplierName("腾讯云通知类消息渠道").build();
        List<SmsRecord> recordList = smsScript.send(smsParam);

        if (!CollUtil.isEmpty(recordList)) {
            smsRecordDao.saveAll(recordList);
        }
    }

    /**
     * 如果有输入链接，则把链接拼在文案后
     * <p>
     * PS: 这里可以考虑将链接 转 短链
     * PS: 如果是营销类的短信，需考虑拼接 回TD退订 之类的文案
     */
    private String getSmsContent(TaskInfo taskInfo) {
        SmsContentModel smsContentModel = (SmsContentModel) taskInfo.getContentModel();
        if (StrUtil.isNotBlank(smsContentModel.getUrl())) {
            return smsContentModel.getContent() + " " + smsContentModel.getUrl();
        } else {
            return smsContentModel.getContent();
        }
    }

}
