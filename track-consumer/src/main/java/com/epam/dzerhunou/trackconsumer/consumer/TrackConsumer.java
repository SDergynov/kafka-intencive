package com.epam.dzerhunou.trackconsumer.consumer;

import com.epam.dzerhunou.trackconsumer.model.Coordinate;
import com.epam.dzerhunou.trackconsumer.model.VehicleSignal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TrackConsumer {

    private final DistanceProducer distanceProducer;

    @KafkaListener(
            groupId = "${application.track-consumer-group}",
            topics = "${application.vehicle-signal-topic}")
    public void consume(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        VehicleSignal vehicleSignal = new ObjectMapper().readValue(consumerRecord.value(), VehicleSignal.class);
        distanceProducer.sendDistance(consumerRecord.key(), getDistance(vehicleSignal));
        log.info("Current distance: {}", getDistance(vehicleSignal));
    }

    private double getDistance(VehicleSignal vehicleSignal) {
        Coordinate destination = vehicleSignal.getDestination();
        Coordinate current = vehicleSignal.getCurrent();
        double deltaX = destination.getLatitude() - current.getLatitude();
        double deltaY = destination.getLongitude() - current.getLongitude();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
}

