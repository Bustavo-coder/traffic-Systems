package services;

import data.repositories.VehicleRepository;
import data.repositories.Vehicles;
import dtos.requests.RegisterVehicleRequest;
import exceptions.VehicleExists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleServiceImplTest {
    private VehicleServices vehicleServices;
    private VehicleRepository vehicleRepository;

    @BeforeEach
    void setUp() {
        vehicleServices = new VehicleServiceImpl();
        vehicleRepository = new Vehicles();
    }

    @AfterEach
    void tearDown() {
        vehicleRepository.deleteALL();
    }
    @Test
    @DisplayName("test i can add a new Vehicle")
    public void registerVehicle(){
        RegisterVehicleRequest request = new RegisterVehicleRequest();
        request.setVehicleChassisNumber("PRTBB");
        vehicleServices.registerVehicle(request);
        assertEquals(vehicleRepository.count(),1);
    }

    @Test
    @DisplayName("test when i tried registering same vehicles")
    public void reisterDuplicate(){
        RegisterVehicleRequest request = new RegisterVehicleRequest();
        request.setVehicleChassisNumber("PRTBB");
        vehicleServices.registerVehicle(request);
        assertEquals(vehicleRepository.count(),1);
        assertThrows(VehicleExists.class, ()-> vehicleServices.registerVehicle(request));
        assertEquals(vehicleRepository.count(),1);
    }

}