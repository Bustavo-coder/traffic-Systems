package services;

import data.models.Officer;
import data.repositories.OfficerRepository;
import data.repositories.Officers;
import data.repositories.VehicleRepository;
import data.repositories.Vehicles;
import dtos.requests.RegisterOfficerRequest;
import dtos.response.RegisterOfficerResponse;
import exceptions.OfficerExists;

import static utils.Mapper.map;


public class officerServiceImpl implements OfficerService {
    private final OfficerRepository officerRepository = new Officers();
    @Override
    public RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request) {
        Officer officer = map(request);
        validateOfficerNin(officer.getNin());
        officerRepository.save(officer);
        return new RegisterOfficerResponse();
    }


    private void validateOfficerNin(String nin){
        if(officerRepository.findByNin(nin) != null) throw  new OfficerExists("Officer Exist Already");
    }

}
