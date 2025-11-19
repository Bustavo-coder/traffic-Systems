package controllers;

import dtos.requests.RegisterOfficerRequest;
import dtos.response.RegisterOfficerResponse;
import services.OfficerService;
import services.officerServiceImpl;

public class OfficerController {
    private static OfficerService officerService = new officerServiceImpl();

    public RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request){
        return officerService.registerOfficer(request);
    }
}
