package trafficSystem.service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import trafficSystem.data.models.Vehicle;
import trafficSystem.data.repositories.VehicleRepository;
import trafficSystem.dtos.requests.*;
import trafficSystem.dtos.response.*;
import trafficSystem.exceptions.VehicleExists;

import java.util.Optional;

import static trafficSystem.utils.Mapper.map;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleServices {
    @Autowired
    private VehicleRepository repository;
    @Override

    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request) {
        Vehicle newVehicle = map(request);
        validateVehicle(newVehicle);
        Vehicle savedVehicle = repository.save(newVehicle);
        return map(savedVehicle);
    }
    private void validateVehicle(Vehicle vehicle){
        Optional<Vehicle> savedVehicle = repository.findBychassisNumber(vehicle.getChassisNumber());
        if(savedVehicle.isPresent()) throw new VehicleExists("Vehicles Exist");
    }
}
