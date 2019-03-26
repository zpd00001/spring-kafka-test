package com.example.kafkademo.singletest;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaCreateTopic {

    public static void main(String args[]){
        Properties properties = new Properties();
        properties.put("bootstrap.servers","192.168.1.174:9092");
        try (AdminClient adminClient = AdminClient.create(properties)) {
            ArrayList<NewTopic> topics = new ArrayList<>();
            NewTopic newTopic = new NewTopic("topic-test",1,(short)1);
            topics.add(newTopic);
            CreateTopicsResult result = adminClient.createTopics(topics);
            try {
                result.all().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
