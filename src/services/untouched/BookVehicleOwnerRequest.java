package services.untouched;

import data.models.Offence;

public class BookVehicleOwnerRequest {
    private int vehicleId;
    private Offence offence;

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
}
