package com.epam.dzerhunou.restservice.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Coordinate {
    @NotNull
    private double latitude;
    @NotNull
    private double longitude;
}
