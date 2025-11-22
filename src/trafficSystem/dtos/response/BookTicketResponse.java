package trafficSystem.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class BookTicketResponse {
    private String issuerName;
    private String ownerName;
    private String Offence;
    private double offenceFee;
    private Boolean hasPaid;
    private String vehicleId;
    private String officerId;
    private LocalDateTime date;


}
