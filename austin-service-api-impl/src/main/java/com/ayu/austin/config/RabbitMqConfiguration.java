package com.ayu.austin.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: aYu
 * @Date: 2022/7/28 10:12
 * @Description: 目前弃用
 */
//@Configuration
public class RabbitMqConfiguration {

    /**
     * 根据模型编写代码:
     * 1. 定义交换机
     * 2. 定义队列
     * 3. 创建交换机
     * 4. 创建队列
     * 5. 队列和交换机的绑定
     */

    public static final String EXCHANGE_AUSTIN = "exchange_austin";

    public static final String QUEUE_AUSTIN = "queue_austin";

    @Bean(EXCHANGE_AUSTIN)
    public Exchange exchange() {
        return ExchangeBuilder                      // 构建交换机
                .topicExchange(EXCHANGE_AUSTIN)        // 使用topic类型
                .durable(true)                      // 设置持久化
                .build();                           //创建
    }

    @Bean(QUEUE_AUSTIN)
    public Queue queue() {
        return new Queue(QUEUE_AUSTIN);
    }

    @Bean
    public Binding binding(@Qualifier(EXCHANGE_AUSTIN) Exchange exchange,
                           @Qualifier(QUEUE_AUSTIN) Queue queue) {

        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("austin.*")
                .noargs();

    }

}
