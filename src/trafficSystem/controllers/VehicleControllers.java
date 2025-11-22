package trafficSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import trafficSystem.dtos.requests.*;
import trafficSystem.dtos.response.*;
import trafficSystem.service.VehicleServices;

@RestController
public class VehicleControllers {
    @Autowired
    private VehicleServices vehicleServices;

    @PostMapping("/vehicle")
    public RegisterVehicleResponse registerVehicle(@RequestBody RegisterVehicleRequest request){
        return vehicleServices.registerVehicle(request);
    }

}
