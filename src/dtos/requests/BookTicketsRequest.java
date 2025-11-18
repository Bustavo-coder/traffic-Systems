package dtos.requests;

import data.models.Offence;
import data.models.Officer;

import java.time.LocalDateTime;

public class BookTicketsRequest {
    private int vehicleId;
    private String offenceName;
    private int officerId;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getOffenceName() {
        return offenceName;
    }

    public void setOffenceName(String offenceName) {
        this.offenceName = offenceName;
    }

    public int getOfficerId() {
        return officerId;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }
}
