package com.example.kafkademo.producers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Component
@EnableScheduling
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Scheduled(cron = "00/1 * * * * ?")
    private void send(){
        String message = UUID.randomUUID().toString();
        ListenableFuture future = kafkaTemplate.send("test",message);
        future.addCallback(o -> System.out.println("send-信息生产成功，加入kafka队列"+message),throwable -> System.out.println("消息发送失败"+message));
    }
}
