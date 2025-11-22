package trafficSystem.dtos.requests;


import lombok.Data;
import trafficSystem.data.models.Gender;

@Data
public class RegisterVehicleRequest {
    private String vehicleName;
    private String vehicleModel;
    private String  vehicleYearOfProduction;
    private String vehicleColor;
    private String vehiclePlateNumber;
    private String vehicleChassisNumber;
    private String ownerName;
    private String OwnerAddress;
    private String ownerPhone;
    private Gender ownerGender;
    private String ownerMail;
}
