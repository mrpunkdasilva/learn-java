package com.example.vehiclefactory.components.sports;

import com.example.vehiclefactory.components.Engine;

public class TurboEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Iniciando motor turbo de alta performance");
    }

    @Override
    public int getHorsepower() {
        return 450;
    }
}