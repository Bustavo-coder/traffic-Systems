package services;

import data.models.Vehicle;
import data.repositories.VehicleRepository;
import data.repositories.Vehicles;
import dtos.requests.RegisterVehicleRequest;
import dtos.response.RegisterVehicleResponse;
import exceptions.VehicleExists;

import static utils.Mapper.map;

public class VehicleServiceImpl implements VehicleServices{
    private VehicleRepository repository = new Vehicles();
    @Override
    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request) {
        Vehicle newVehicle = map(request);
        validateVehicle(newVehicle);
        Vehicle savedVehicle = repository.save(newVehicle);
        return map(savedVehicle);
    }
    private void validateVehicle(Vehicle vehicle){
        if(repository.findByChassisNumber(vehicle.getChassisNumber()) != null) throw new VehicleExists("Vehicles Exist");
    }
}
