package dtos.requests;

import data.models.Offence;
import data.models.Officer;

import java.time.LocalDateTime;

public class BookTicketsRequest {

    private int vehicleId;
    private Offence offence;
    private boolean hasPaid;
    private Officer issuer;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Offence getOffence() {
        return offence;
    }

    public void setOffence(Offence offence) {
        this.offence = offence;
    }

    public boolean getHasPaid() {
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

    public LocalDateTime getDateOfBooking() {
        return dateOfBooking;
    }

    private final LocalDateTime dateOfBooking = LocalDateTime.now();
}
