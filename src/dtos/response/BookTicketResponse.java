package dtos.response;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookTicketResponse {
    private String issuerName;
    private String ownerName;
    private String Offence;
    private String dateOfBooking;
    private double offenceFee;
    private Boolean hasPaid;
    private int vehicleId;
    private int officerId;

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }


    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOffence() {
        return Offence;
    }

    public void setOffence(String offence) {
        Offence = offence;
    }

    public void setDateOfBooking(LocalDateTime localDateTime) {
        dateOfBooking = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(localDateTime);
    }

    public String getDateOfBooking() {
        return dateOfBooking;
    }

    public double getOffenceFee() {
        return offenceFee;
    }

    public void setOffenceFee(double offenceFee) {
        this.offenceFee = offenceFee;
    }

    public Boolean getHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(Boolean hasPaid) {
        this.hasPaid = hasPaid;
    }
}
