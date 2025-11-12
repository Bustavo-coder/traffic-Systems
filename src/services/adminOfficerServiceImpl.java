package services;

import data.models.Officer;
import data.models.Ticket;
import data.models.Vehicle;
import data.repositories.OfficerRepository;
import data.repositories.Officers;
import data.repositories.VehicleRepository;
import data.repositories.Vehicles;
import dtos.requests.BookTicketsRequest;
import dtos.requests.RegisterOfficerRequest;
import dtos.response.BookTicketResponse;
import dtos.response.RegisterOfficerResponse;
import exceptions.OfficerExists;

import static utils.Mapper.map;


public class adminOfficerServiceImpl implements adminOfficerService {
    private final OfficerRepository officerRepository = new Officers();
    private final VehicleRepository vehicleRepository = new Vehicles();

    @Override
    public RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request) {
        Officer officer = map(request);
        validateOfficerNin(officer.getNin());
        officerRepository.save(officer);
        return new RegisterOfficerResponse();
    }

    @Override
    public BookTicketResponse bookTickets(BookTicketsRequest request) {
        officerRepository.findById(request.getIssuer().getId());
         Vehicle vehicle = vehicleRepository.findById(request.getVehicleId());
        Ticket ticket = map(request);
        vehicle.getTickets().add(ticket);
        return new BookTicketResponse();
    }

    private void validateOfficerNin(String nin){
        if(officerRepository.findByNin(nin) != null) throw  new OfficerExists("Officer Exist Already");
    }

}
