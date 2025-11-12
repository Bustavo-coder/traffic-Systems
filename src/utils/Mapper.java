package utils;

import data.models.Officer;
import data.models.Owner;
import data.models.Ticket;
import data.models.Vehicle;
import dtos.requests.BookTicketsRequest;
import dtos.requests.RegisterOfficerRequest;
import dtos.requests.RegisterVehicleRequest;

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
        ticket.setIssuer(request.getIssuer());
        ticket.setOffence(request.getOffence());
        ticket.setHasPaid(request.getHasPaid());
        return ticket;
    }

}
