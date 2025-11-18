package services;

import dtos.requests.RegisterOfficerRequest;
import dtos.response.RegisterOfficerResponse;

public interface OfficerService {
    RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request);
}
