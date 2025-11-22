package trafficSystem.dtos.response;

import lombok.Data;

@Data
public class SettleTicketResponse {
    private String Offence;
    private String dateOfPayment;
    private Boolean hasPaid;
    private String ownerName;
    private String vehicleId;


//    public void setDateOfPayment(LocalDateTime localDateTime){
//        dateOfPayment = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(localDateTime);
//    }
}
