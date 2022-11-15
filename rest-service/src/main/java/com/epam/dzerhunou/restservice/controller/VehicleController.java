package com.epam.dzerhunou.restservice.controller;

import com.epam.dzerhunou.restservice.model.Vehicle;
import com.epam.dzerhunou.restservice.model.VehicleSignal;
import com.epam.dzerhunou.restservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/vehicle")
@Slf4j
public class VehicleController {
    private final VehicleService vehicleService;
    @Value("${spring.kafka.bootstrap-servers}")
    private String server;

    @PostMapping("/{id}/signal")
    public ResponseEntity<Vehicle> createVehicleSignal(
            @Valid @RequestBody VehicleSignal vehicleSignal,
            @PathVariable Long id
    ) {
        log.info("Signal controller, signal for vehicle: {}", id);
        Vehicle vehicle = vehicleService.createSignal(id, vehicleSignal);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleS(
            @PathVariable Long id
    ) {
        log.info("Get vehicle with id: {}", id);
        return new ResponseEntity<>(new Vehicle("Vehicle " + id, id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> getTest(
    ) {
        log.info("Test passed");
        log.info("Server: {}", server);
        return new ResponseEntity<>("Test passed", HttpStatus.OK);
    }
}
