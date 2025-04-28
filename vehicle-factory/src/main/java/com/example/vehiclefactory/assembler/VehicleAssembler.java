package com.example.vehiclefactory.assembler;

import com.example.vehiclefactory.factory.VehicleFactory;
import com.example.vehiclefactory.model.Vehicle;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VehicleAssembler {
    private final VehicleFactory factory;
    
    public Vehicle assembleVehicle() {
        return new Vehicle(
            factory.createEngine(),
            factory.createBody(),
            factory.createInterior()
        );
    }
}