package com.epam.dzerhunou.restservice.service;

import com.epam.dzerhunou.restservice.model.Vehicle;
import org.springframework.stereotype.Service;


@Service
public class VehicleService {
    public Vehicle createSignal(Long id){
        return new Vehicle(id);
    }
}
