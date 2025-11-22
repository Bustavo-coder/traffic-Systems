package trafficSystem.utils;


import trafficSystem.data.models.*;
import trafficSystem.dtos.requests.*;
import trafficSystem.dtos.response.*;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static Vehicle map(RegisterVehicleRequest request){
        Vehicle vehicle = new Vehicle();
        vehicle.setChassisNumber(request.getVehicleChassisNumber());
        vehicle.setColor(request.getVehicleColor());
        vehicle.setName(request.getVehicleName());
        vehicle.setModel(request.getVehicleModel());
        vehicle.setOwner(mapOwner(request));
        return vehicle;
    }
    private static Owner mapOwner(RegisterVehicleRequest request){
        Owner owner = new Owner();
        owner.setName(request.getOwnerName());
        owner.setMail(request.getOwnerMail());
        owner.setAddress(request.getOwnerAddress());
        owner.setPhone(request.getOwnerPhone());
        owner.setGender(request.getOwnerGender());
        return owner;
    }

    public static Officer map(RegisterOfficerRequest request){
        Officer officer = new Officer();
        officer.setName(request.getName());
        officer.setRank(officer.getRank());
        officer.setNin(request.getNin());
        return officer;
    }

    public static Ticket map(BookTicketsRequest request){
        Ticket ticket = new Ticket();
        ticket.setOffence(Offence.valueOf(request.getOffenceName()));
        return ticket;
    }

    public static RegisterVehicleResponse map(Vehicle savedVehicle){
        RegisterVehicleResponse response = new RegisterVehicleResponse();
        response.setOwnerName(savedVehicle.getOwner().getName());
        response.setVehicleId(savedVehicle.getId());
        response.setVehicleDetails(savedVehicle.toString());
        return response;
    }

    public static RegisterOfficerResponse map(Officer savedOfficer){
        RegisterOfficerResponse response = new RegisterOfficerResponse();
        response.setName(savedOfficer.getName());
        response.setId(savedOfficer.getId());
        return response;
    }

    public static BookTicketResponse map(Ticket savedTicket){
        BookTicketResponse response = new BookTicketResponse();
        response.setDateOfBooking(savedTicket.getDateOfBooking());
        response.setIssuerName(savedTicket.getIssuer().getName());
        response.setHasPaid(savedTicket.isHasPaid());
        response.setOffenceFee(savedTicket.getOffence().price);
        response.setOwnerName(savedTicket.getVehicle().getOwner().getName());
        response.setOfficerId(savedTicket.getIssuer().getId());
        response.setVehicleId(savedTicket.getVehicle().getId());
        response.setOffence(savedTicket.getOffence().name());
        response.setOffenceFee(savedTicket.getOffence().price);
        return  response;
    }

    public static SettleTicketResponse mapToSettle(Ticket savedTicket){
        SettleTicketResponse response = new SettleTicketResponse();
        String date = DateTimeFormatter.ofPattern("yyy-MM-dd hh:mm:s").format(savedTicket.getDateOfBooking());
        response.setDateOfPayment(date);
        response.setHasPaid(savedTicket.isHasPaid());
        response.setOffence(savedTicket.getOffence().name());
        response.setOwnerName(savedTicket.getVehicle().getOwner().getName());
        response.setVehicleId(savedTicket.getVehicle().getId());
        return response;


    }

    public static ViewTicketResponse mapView(Ticket savedTicket){
        ViewTicketResponse response = new ViewTicketResponse();
        String date = DateTimeFormatter.ofPattern("yyy-MM-dd hh:mm:s").format(savedTicket.getDateOfBooking());
        response.setDateOfBooking(date);
        response.setIssuerName(savedTicket.getIssuer().getName());
        response.setTicketId(savedTicket.getId());
        response.setHasPaid(savedTicket.isHasPaid());
        response.setOfficerId(savedTicket.getIssuer().getId());
        response.setVehicleId(savedTicket.getId());
        response.setOwnerName(savedTicket.getVehicle().getName());
        response.setVehicleId(savedTicket.getVehicle().getId());
    return response;
    }

}
