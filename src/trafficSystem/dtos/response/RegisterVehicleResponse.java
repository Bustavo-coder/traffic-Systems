package trafficSystem.dtos.response;

import lombok.Data;

@Data
public class RegisterVehicleResponse {
    private String vehicleId;
    private String  ownerName;
    private String vehicleDetails;
}
