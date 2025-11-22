package trafficSystem.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trafficSystem.*;
import trafficSystem.data.models.Officer;
import trafficSystem.data.repositories.OfficerRepository;
import trafficSystem.dtos.requests.*;
import trafficSystem.dtos.response.*;
import trafficSystem.exceptions.OfficerExists;

import java.util.Optional;

import static trafficSystem.utils.Mapper.map;


@Service
@NoArgsConstructor
@AllArgsConstructor

public class officerServiceImpl implements OfficerService{
    @Autowired
    private OfficerRepository officerRepository ;

    @Override
    public RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request) {
        Officer officer = map(request);
        validateOfficerNin(officer.getNin());
        Officer savedOfficer = officerRepository.save(officer);
        return map(savedOfficer);
    }

    private void validateOfficerNin(String nin){
        Optional<Officer> foundOfficer = officerRepository.findByNin(nin);
        if(foundOfficer.isPresent()) throw new OfficerExists("Officer Exist Already");
    }

}
