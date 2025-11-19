package dtos.response;

import data.models.Offence;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SettleTicketResponse {
    private String Offence;
    private String dateOfPayment;
    private Boolean hasPaid;
    private String ownerName;
    private int vehicleId;

    public String getOffence() {
        return Offence;
    }

    public void setOffence(Offence offence) {
        Offence = offence.name();
    }
    public void setDateOfPayment(LocalDateTime localDateTime){
        dateOfPayment = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(localDateTime);
    }


    public String  getDateOfPayment() {
        return dateOfPayment;
    }

    public Boolean getHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(Boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
}
