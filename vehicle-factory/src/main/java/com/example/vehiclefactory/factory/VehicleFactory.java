package com.example.vehiclefactory.factory;

import com.example.vehiclefactory.components.Engine;
import com.example.vehiclefactory.components.Body;
import com.example.vehiclefactory.components.Interior;

public interface VehicleFactory {
    Engine createEngine();
    Body createBody();
    Interior createInterior();
}