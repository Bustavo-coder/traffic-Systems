package trafficSystem.data.models;
import lombok.*;

@ToString
@Data
@NoArgsConstructor

public class Owner {
    private String name;
    private String address;
    private String phone;
    private Gender gender;
    private String mail;



}
