package com.epam.dzerhunou.restservice.service;

import com.epam.dzerhunou.restservice.model.Vehicle;
import com.epam.dzerhunou.restservice.model.VehicleSignal;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
@Setter
public class VehicleService {

    @Value("${application.vehicle-signal-topic}")
    private String inputTopic;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public Vehicle createSignal(Long id, VehicleSignal signal) {
        log.info("Send signal for vehicle {}", id);
        kafkaTemplate.send(inputTopic, id.toString(), signal);
        return new Vehicle("Vehicle " + id, id);
    }
}
