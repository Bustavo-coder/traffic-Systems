package services;

import data.models.Offence;
import data.models.Officer;
import data.models.Ticket;
import data.models.Vehicle;
import data.repositories.OfficerRepository;
import data.repositories.TicketsRepository;
import data.repositories.VehicleRepository;
import dtos.requests.BookTicketsRequest;
import dtos.requests.SettleTicketRequest;
import dtos.requests.ViewTicketRequest;
import dtos.response.SettleTicketResponse;
import dtos.response.ViewTicketResponse;
import dtos.response.BookTicketResponse;
import exceptions.*;

import java.util.ArrayList;

public class TicketServiceIml implements TicketService{
    private final OfficerRepository officerRepository;
    private final VehicleRepository vehicleRepository;
    private TicketsRepository ticketsRepository;

    public TicketServiceIml(VehicleRepository vehicleRepository, OfficerRepository officerRepo,TicketsRepository ticketsRepository){
        this.officerRepository = officerRepo;
        this.vehicleRepository = vehicleRepository;
        this.ticketsRepository = ticketsRepository;
    }

    @Override
    public BookTicketResponse bookTicket(BookTicketsRequest request) {
        Officer issuer = searchForOfficer(request.getOfficerId());
        validateIssuer(issuer);
        Vehicle savedvehicle = searchForVehicle(request.getVehicleId());
        validateVehicle(savedvehicle);


        Ticket ticket = new Ticket();
        ticket.setOffence(Offence.valueOf(request.getOffenceName()));
        ticket.setIssuer(issuer);
        ticket.setVehicle(savedvehicle);

        ticketsRepository.save(ticket);
        savedvehicle.getTickets().add(ticket);
        vehicleRepository.save(savedvehicle);
        return null;
    }

    @Override
    public ViewTicketResponse viewTickets(ViewTicketRequest request) {
        Vehicle vehicle = searchForVehicle(request.getVehicleId());
        validateVehicle(vehicle);

        ArrayList<Ticket> listOfTickets = new ArrayList<>();
        for (Ticket ticket : ticketsRepository.findAll().values()){
            if(ticket.getVehicle() == vehicle) listOfTickets.add(ticket);
        }

      return new ViewTicketResponse();
    }

    @Override
    public SettleTicketResponse settleTicket(SettleTicketRequest request) {
        Vehicle searchedVehicle = searchForVehicle(request.getVehicleId());
        validateVehicle(searchedVehicle);

        Ticket searchedTicket = searchForTicket(request.getTicketId());
        validateTicket(request.getTicketId());

        double offenceFee = request.getOffenceFee();
        validateOffenceFee(request);

        validateTicketStatus(searchedTicket);
        searchedTicket.setPaymentStatus(true);
        ticketsRepository.save(searchedTicket);
        return null;

    }


    private void validateIssuer(Officer officer){
        if(officer == null) throw new OfficerNotFound("Officer Does Not Exist");
    }

    private void validateVehicle(Vehicle vehicle){
        if(vehicle == null) throw new VehicleNotRegisterd("Vehicle is Not Registered");
    }

    private void validateOffenceFee(SettleTicketRequest request){
        Ticket searchedTicket = searchForTicket(request.getTicketId());
        Offence offence = searchedTicket.getOffence();
        if(offence.price != request.getOffenceFee()) throw new InvalidOffenceFee("Invalid Amount");
    }

    private Ticket searchForTicket(int id){
        return ticketsRepository.findById(id);
    }

    private void validateTicket(int id){
        if(searchForTicket(id) == null) throw new TicketNotFound("Ticket Not Found");
    }

    private void validateTicketStatus(Ticket ticket){
        if(ticket.getPaymentStatus()) throw new PaidTicketExceptions("Ticket Status Has Been Settled");

    }
    private Vehicle searchForVehicle(int id){
        return vehicleRepository.findById(id);
    }

    private Officer searchForOfficer(int id){
        return officerRepository.findById(id);
    }

}
