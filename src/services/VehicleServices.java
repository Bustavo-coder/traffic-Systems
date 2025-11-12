package services;

import dtos.requests.RegisterVehicleRequest;
import dtos.response.RegisterVehicleResponse;

public interface VehicleServices {
    RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request);
}
