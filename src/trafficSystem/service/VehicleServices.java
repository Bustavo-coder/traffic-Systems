package trafficSystem.service;


import trafficSystem.dtos.requests.RegisterVehicleRequest;
import trafficSystem.dtos.response.RegisterVehicleResponse;

public interface VehicleServices {
    RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request);
}
