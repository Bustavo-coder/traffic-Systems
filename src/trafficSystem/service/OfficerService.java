package trafficSystem.service;


import trafficSystem.dtos.requests.RegisterOfficerRequest;
import trafficSystem.dtos.response.RegisterOfficerResponse;

public interface OfficerService {
    RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request);
}
