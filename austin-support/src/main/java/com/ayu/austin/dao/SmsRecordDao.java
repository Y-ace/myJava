package com.ayu.austin.dao;

import com.ayu.austin.domain.SmsRecord;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author: aYu
 * @Date: 2022/7/27 15:14
 * @Description:
 */
public interface SmsRecordDao extends CrudRepository<SmsRecord, Long> {
}
