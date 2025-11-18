package dtos.requests;

public class SettleTicketRequest {
    private double offenceFee;
    private int ticketId;
    private int vehicleId;

    public double getOffenceFee() {
        return offenceFee;
    }

    public void setOffenceFee(double offenceFee) {
        this.offenceFee = offenceFee;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
}
