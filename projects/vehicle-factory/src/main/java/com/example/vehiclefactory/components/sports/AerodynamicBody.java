package com.example.vehiclefactory.components.sports;

import com.example.vehiclefactory.components.Body;

public class AerodynamicBody implements Body {
    @Override
    public String getDesign() {
        return "Design aerodinâmico esportivo";
    }

    @Override
    public double getAerodynamics() {
        return 0.28;
    }
}