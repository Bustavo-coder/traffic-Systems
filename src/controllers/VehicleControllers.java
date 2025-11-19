package controllers;

import dtos.requests.RegisterVehicleRequest;
import dtos.response.RegisterVehicleResponse;
import services.VehicleServiceImpl;
import services.VehicleServices;

public class VehicleControllers {
    private static VehicleServices vehicleServices = new VehicleServiceImpl();

    public RegisterVehicleResponse registerVehicle(RegisterVehicleRequest request){
        return vehicleServices.registerVehicle(request);
    }

}
