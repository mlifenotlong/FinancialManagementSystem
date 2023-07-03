package com.cj.controller;

//import com.lockie.cloudorder.model.R;
import com.cj.util.R;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * @author: htl
 * @Date: 2023/1/17 11:17
 * @Description:
 */
@RestController
@RequestMapping("/mqProducer")
public class MQProducerController {
    public static final Logger LOGGER = LoggerFactory.getLogger(MQProducerController.class);

//    @Autowired
//    DefaultMQProducer defaultMQProducer;

    /**
     * 发送简单的MQ消息
     * @param msg
     * @return
     */
//    @GetMapping("/send")
//    public R send(String msg) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
//        if (StringUtils.isEmpty(msg)) {
//            return R.ok();
//        }
//        LOGGER.info("发送MQ消息内容：" + msg);
//        Message sendMsg = new Message("TestTopic", "TestTag", msg.getBytes());
//
//        // 延时级别 "1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h"
//        // 设置消息延迟级别为3，也就是延迟10s。
//        sendMsg.setDelayTimeLevel(3);
//
//        // 定时发送消息，5秒之后发送
//
////        sendMsg.setDeliveryTimestamp(System.currentTimeMillis() + Duration.ofSeconds(5).toMillis());
//
//        // 默认3秒超时
//        SendResult sendResult = defaultMQProducer.send(sendMsg);
//        LOGGER.info("消息发送响应：" + sendResult.toString());
//        return R.ok();
//    }
    @Resource
    private RocketMQTemplate rocketMQTemplate;
@RequestMapping("TEST")
    public  Integer getTest(){
    rocketMQTemplate.syncSend("springTopic", "Hello, World!");
    return 1;
}
}