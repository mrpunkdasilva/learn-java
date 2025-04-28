package com.example.vehiclefactory.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Vehicle {
    private final Engine engine;
    private final Body body;
    private final Interior interior;
}