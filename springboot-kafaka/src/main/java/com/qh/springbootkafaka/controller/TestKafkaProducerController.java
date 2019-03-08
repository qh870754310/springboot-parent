package com.qh.springbootkafaka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qh
 * @Date: 2019/3/5 17:37
 * @Description: 生产者
 */
@RestController
@RequestMapping(value = "kafka")
public class TestKafkaProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 当在浏览器上输入http://localhost:8080/kafka/send?msg=abc，就会发送abc到服务器上去让消费者接收，msg对应下面的String msg
     * @param msg
     * @return
     */
    @RequestMapping(value = "send")
    public String send(String msg) {
        kafkaTemplate.send("test_topic", msg); //使用kafka模板发送信息
        return "success";
    }
}
