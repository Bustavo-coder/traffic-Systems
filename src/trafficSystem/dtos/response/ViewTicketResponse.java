package trafficSystem.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Data
public class ViewTicketResponse {
    private String issuerName;
    private String ownerName;
    private String vehicleName;
    private String Offence;
    private String dateOfBooking;
    private Double offenceFee;
    private Boolean hasPaid;
    private String  vehicleId;
    private String  ticketId;
}