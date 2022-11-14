package com.epam.dzerhunou.trackconsumer.model;

import lombok.Data;

@Data
public class VehicleSignal {
    private Coordinate current;
    private Coordinate destination;
}
