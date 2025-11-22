package trafficSystem.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class BookTicketResponse {
    private String issuerName;
    private String ownerName;
    private String Offence;
    private String dateOfBooking;
    private double offenceFee;
    private Boolean hasPaid;
    private String vehicleId;
    private String officerId;

    public void setDateOfBooking(LocalDateTime localDateTime) {
        dateOfBooking = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(localDateTime);
    }


}
