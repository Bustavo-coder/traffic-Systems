package trafficSystem.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document("Officers")
public class Officer {
    @Id
    private String id;
    private String name;
    private String rank;
    private String nin;

}
