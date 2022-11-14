package com.epam.dzerhunou.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class DistanceConsumer {

    private final Map<String, Double> distance = new HashMap<>();

    @KafkaListener(
            groupId = "track_consumer",
            topics = "output_topic")
    public void consume(ConsumerRecord<String, String> consumerRecord) {
        log.info("Vehicle id: {} - Total distance: {}", consumerRecord.key(),
                getTotalDistance(consumerRecord.key(), consumerRecord.value()));
    }

    private double getTotalDistance(String key, String value) {
        double vehicleDistance;
        log.info("key {}, value {}", key, value);
        if (distance.containsKey(key)) {
            vehicleDistance = distance.get(key) + Double.parseDouble(value);
            log.debug("id: {}, stored distance {}", key, distance.get(key));
        } else {
            vehicleDistance = Double.parseDouble(value);
        }
        distance.put(key, vehicleDistance);
        return vehicleDistance;
    }
}
