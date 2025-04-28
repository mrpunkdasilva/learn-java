package com.example.vehiclefactory.factory;

import com.example.vehiclefactory.components.*;
import com.example.vehiclefactory.components.sports.*;

public class SportsCarFactory implements VehicleFactory {
    @Override
    public Engine createEngine() {
        return new TurboEngine();
    }

    @Override
    public Body createBody() {
        return new AerodynamicBody();
    }

    @Override
    public Interior createInterior() {
        return new SportInterior();
    }
}