package trafficSystem.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("Vehicles")
public class Vehicle {
    @Id
    private String id;
    private String name;
    private String model;
    private String year;
    private String color;
    private String plateNumber;
    private Owner owner;
    private String chassisNumber;
//    private List<Ticket> tickets = new ArrayList<>();

}
