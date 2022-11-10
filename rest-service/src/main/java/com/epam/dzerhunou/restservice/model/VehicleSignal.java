package com.epam.dzerhunou.restservice.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VehicleSignal {
    @NotNull
    private float currentLatitude;
    @NotNull
    private float currentAttitude;
    @NotNull
    private float destinationLatitude;
    @NotNull
    private float destinationAttitude;
}
