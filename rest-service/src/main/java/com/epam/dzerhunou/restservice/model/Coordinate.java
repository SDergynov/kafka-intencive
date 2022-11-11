package com.epam.dzerhunou.restservice.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Coordinate {
    @NotNull
    private float latitude;
    @NotNull
    private float longitude;
}
