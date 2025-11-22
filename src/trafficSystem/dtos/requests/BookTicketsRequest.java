package trafficSystem.dtos.requests;

import lombok.Data;

@Data
public class BookTicketsRequest {
    private String vehicleId;
    private String offenceName;
    private String officerId;
}
