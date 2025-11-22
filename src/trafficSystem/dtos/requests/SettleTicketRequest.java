package trafficSystem.dtos.requests;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SettleTicketRequest {
    private String offenceFee;
    private String ticketId;
    private String vehicleId;
}
