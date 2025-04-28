package com.example.vehiclefactory;

import com.example.vehiclefactory.assembler.VehicleAssembler;
import com.example.vehiclefactory.factory.SportsCarFactory;
import com.example.vehiclefactory.model.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleFactoryTest {

    @Test
    void shouldCreateSportsCar() {
        VehicleAssembler assembler = new VehicleAssembler(new SportsCarFactory());
        Vehicle vehicle = assembler.assembleVehicle();
        
        assertNotNull(vehicle);
        assertEquals(450, vehicle.getEngine().getHorsepower());
        assertEquals(2, vehicle.getInterior().getSeatingCapacity());
        assertEquals(0.28, vehicle.getBody().getAerodynamics());
    }
}