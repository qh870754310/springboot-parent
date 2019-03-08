package com.qh.springbootkafaka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qh
 * @Date: 2019/3/6 9:44
 * @Description:
 */
@Configuration
@EnableKafka  //声明Config并且打开KafkaTemplate能力。
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String servers;
    @Value("${spring.kafka.producer.retries}")
    private int retries;
    @Value("${spring.kafka.producer.batch.size}")
    private int batchSize;
    @Value("${spring.kafka.producer.linger}")
    private int linger;
    @Value("${spring.kafka.producer.buffer.memory}")
    private int bufferMemory;

    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        return props;
    }
}
