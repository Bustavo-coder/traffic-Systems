package services.untouched;

import data.models.Offence;
import data.models.Officer;
import data.models.Ticket;
import data.models.Vehicle;

public class RegisterTicketMapper {
    private Vehicle vehicle;
    private Offence offence;
    private boolean hasPaid;
    private Officer issuer;

    public static Ticket map(RegisterTicketRequest request){
        Ticket ticket = new Ticket();
        ticket.setOffence(request.getOffence());
        ticket.setVehicle(request.getVehicle());
        ticket.setIssuer(request.getIssuer());
        ticket.setHasPaid(request.HasPaid());
        return ticket;
    }
}
