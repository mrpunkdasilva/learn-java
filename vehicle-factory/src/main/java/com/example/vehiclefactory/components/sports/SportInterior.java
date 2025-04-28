package com.example.vehiclefactory.components.sports;

import com.example.vehiclefactory.components.Interior;

public class SportInterior implements Interior {
    @Override
    public int getSeatingCapacity() {
        return 2;
    }

    @Override
    public String getUpholsteryType() {
        return "Couro esportivo com costuras contrastantes";
    }
}