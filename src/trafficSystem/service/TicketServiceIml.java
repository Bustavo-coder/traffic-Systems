package trafficSystem.service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trafficSystem.data.models.*;
import trafficSystem.data.repositories.*;
import trafficSystem.dtos.requests.*;
import trafficSystem.dtos.response.*;
import trafficSystem.exceptions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static trafficSystem.utils.Mapper.*;

@Service
@AllArgsConstructor
@NoArgsConstructor

public class TicketServiceIml implements TicketService {
    @Autowired
    private  OfficerRepository officerRepository;

    @Autowired
    private  VehicleRepository vehicleRepository;

    @Autowired
    private TicketsRepository ticketsRepository;



    @Override
    public BookTicketResponse bookTicket(BookTicketsRequest request) {
        System.out.println(request.getOfficerId());
        Officer issuer = searchForOfficer(request.getOfficerId());
        validateIssuer(issuer);

        Vehicle savedvehicle = searchForVehicle(request.getVehicleId());
        validateVehicle(savedvehicle);


        Ticket ticket = map(request);
        ticket.setOffence(Offence.valueOf(request.getOffenceName()));
        ticket.setIssuer(issuer);
        ticket.setVehicle(savedvehicle);

       Ticket savedTicket =  ticketsRepository.save(ticket);
        return map(savedTicket);
    }


    @Override
    public ArrayList<ViewTicketResponse> viewTickets(String request) {
        Vehicle vehicle = searchForVehicle(request);
        validateVehicle(vehicle);

        ArrayList<Ticket> listOfTickets = new ArrayList<>();
      ArrayList <ViewTicketResponse> viewTicket = new ArrayList<>();
        for (Ticket ticket : ticketsRepository.findAll()){
            if(ticket.getVehicle().getId().equals(vehicle.getId())) listOfTickets.add(ticket);
        }
        listOfTickets.forEach(ticket -> viewTicket.add(mapView(ticket)));
        System.out.println(listOfTickets.size());
      return viewTicket;
    }



    @Override
    public SettleTicketResponse settleTicket(SettleTicketRequest request) {
        Ticket searchedTicket = searchForTicket(request.getTicketId());
        validateTicket(searchedTicket);

        Double offenceFee = Double.parseDouble(request.getOffenceFee());
        validateOffenceFee(request);

        validateTicketStatus(searchedTicket);
        searchedTicket.setHasPaid(true);
        Ticket settledTicket = ticketsRepository.save(searchedTicket);
        return mapToSettle(settledTicket);
    }


    private void validateIssuer(Officer officer){
        if(officer == null) throw new OfficerNotFound("Officer Does Not Exist");
    }

    private void validateVehicle(Vehicle vehicle){
        if(vehicle == null) throw new VehicleNotRegisterd("Vehicle is Not Registered");
    }

    private void validateOffenceFee(SettleTicketRequest request){
        Ticket searchedTicket = searchForTicket(request.getTicketId());
        validateTicket(searchedTicket);
        Offence offence = searchedTicket.getOffence();
        if(offence.price != Double.parseDouble(request.getOffenceFee())) throw new InvalidOffenceFee("Invalid Amount");
    }

    private Ticket searchForTicket(String id){
        return ticketsRepository.findById(id).isPresent() ? ticketsRepository.findById(id).get() : null;
    }

    private void validateTicket(Ticket ticket){
        if(ticket == null) throw new TicketNotFound("Ticket Not Found");
    }

    private void validateTicketStatus(Ticket ticket){
        if(ticket.isHasPaid()) throw new PaidTicketExceptions("Ticket Status Has Been Settled");

    }
    private Vehicle searchForVehicle(String id){
        return vehicleRepository.findById(id).isPresent() ? vehicleRepository.findById(id).get() : null;
    }

    private Officer searchForOfficer(String id){
        return officerRepository.findById(id).isPresent() ? officerRepository.findById(id).get() : null;
    }

}
