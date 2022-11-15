package com.epam.dzerhunou.restservice.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VehicleSignal {
    @NotNull
    private Coordinate current;
    @NotNull
    private Coordinate destination;
}
