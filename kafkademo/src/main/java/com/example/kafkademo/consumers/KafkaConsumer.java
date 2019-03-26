package com.example.kafkademo.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"test"})
    public void receive(String message){
        System.out.println("消费者收到消息："+message);
    }
}
