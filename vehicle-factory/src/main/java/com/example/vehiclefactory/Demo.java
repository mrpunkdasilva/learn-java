package com.example.vehiclefactory;

import com.example.vehiclefactory.assembler.VehicleAssembler;
import com.example.vehiclefactory.factory.SportsCarFactory;
import com.example.vehiclefactory.model.Vehicle;

public class Demo {
    public static void main(String[] args) {
        // Criar e testar um carro esportivo
        VehicleAssembler assembler = new VehicleAssembler(new SportsCarFactory());
        Vehicle sportsCar = assembler.assembleVehicle();
        
        // Testar o veículo
        System.out.println("=== Testando Carro Esportivo ===");
        sportsCar.getEngine().start();
        System.out.println("Potência: " + sportsCar.getEngine().getHorsepower() + " hp");
        System.out.println("Design: " + sportsCar.getBody().getDesign());
        System.out.println("Capacidade: " + sportsCar.getInterior().getSeatingCapacity() + " pessoas");
        System.out.println("Tipo de estofamento: " + sportsCar.getInterior().getUpholsteryType());
    }
}