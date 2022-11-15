package com.epam.dzerhunou.trackconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DistanceProducer {

    @Value("${application.vehicle-distance-topic}")
    private String outputTopic;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendDistance(String key, double distance){
        kafkaTemplate.send(outputTopic, key, distance);
    }
}
