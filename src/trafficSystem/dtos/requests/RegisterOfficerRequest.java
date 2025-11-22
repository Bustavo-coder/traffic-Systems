package trafficSystem.dtos.requests;

import lombok.Data;

@Data
public class RegisterOfficerRequest {
    private String name;
    private String rank;
    private String nin;
}
