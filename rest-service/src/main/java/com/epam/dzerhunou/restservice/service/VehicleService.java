package com.epam.dzerhunou.restservice.service;

import com.epam.dzerhunou.restservice.model.Vehicle;
import com.epam.dzerhunou.restservice.model.VehicleSignal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleService {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public Vehicle createSignal(Long id, VehicleSignal signal) {
        log.info("Send signal for vehicle {}", id);
        kafkaTemplate.send("input_topic", id.toString(), signal);
        return new Vehicle("Vehicle " + id, id);
    }
}
