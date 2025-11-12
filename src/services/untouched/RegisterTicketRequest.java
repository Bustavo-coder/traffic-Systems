package services.untouched;

import data.models.Offence;
import data.models.Officer;
import data.models.Vehicle;

public class RegisterTicketRequest {
    private Vehicle vehicle;
    private Offence offence;
    private boolean hasPaid;
    private Officer issuer;


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Offence getOffence() {
        return offence;
    }

    public void setOffence(Offence offence) {
        this.offence = offence;
    }

    public boolean HasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }
    public Officer getIssuer() {
        return issuer;
    }

    public void setIssuer(Officer issuer) {
        this.issuer = issuer;
    }
}
