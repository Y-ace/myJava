package com.ayu.austin.pipeline;

import java.util.List;

/**
 * @Author: aYu
 * @Date: 2022/7/27 19:46
 * @Description: 业务执行模板（把责任链的逻辑串起来）
 */
public class ProcessTemplate {

    private List<BusinessProcess> processList;

    public List<BusinessProcess> getProcessList() {
        return processList;
    }

    public void setProcessList(List<BusinessProcess> processList) {
        this.processList = processList;
    }
}