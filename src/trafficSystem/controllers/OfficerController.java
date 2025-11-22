package trafficSystem.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trafficSystem.dtos.requests.*;
import trafficSystem.dtos.response.*;
import trafficSystem.service.OfficerService;

@RestController
@NoArgsConstructor
@RequestMapping("/officers")
@AllArgsConstructor
public class OfficerController {
    @Autowired
    private OfficerService officerService;

    @PostMapping("/officer")
    public RegisterOfficerResponse registerOfficer(@RequestBody RegisterOfficerRequest request){
        return officerService.registerOfficer(request);
    }
}
