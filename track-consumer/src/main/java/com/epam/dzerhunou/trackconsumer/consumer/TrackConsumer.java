package com.epam.dzerhunou.trackconsumer.consumer;

import com.epam.dzerhunou.trackconsumer.model.Coordinate;
import com.epam.dzerhunou.trackconsumer.model.VehicleSignal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TrackConsumer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(
            groupId = "track_consumer",
            topics = "input_topic")
    public void consume(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        VehicleSignal vehicleSignal = new ObjectMapper().readValue(consumerRecord.value(), VehicleSignal.class);
        kafkaTemplate.send("output_topic", consumerRecord.key(), getDistance(vehicleSignal));
        log.info("current distance: {}", getDistance(vehicleSignal));
    }

    private double getDistance(VehicleSignal vehicleSignal) {
        Coordinate destination = vehicleSignal.getDestination();
        Coordinate current = vehicleSignal.getCurrent();
        double deltaX = destination.getLatitude() - current.getLatitude();
        double deltaY = destination.getLongitude() - current.getLongitude();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
}

