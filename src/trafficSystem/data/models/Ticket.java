package trafficSystem.data.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@ToString
@NoArgsConstructor
@Document("Tickets")

public class Ticket {
    @Id
    private String id;
    @DBRef
    private Vehicle vehicle;
    private Offence offence;
    private boolean hasPaid;
    @DBRef
    private Officer issuer;
    private LocalDateTime dateOfBooking;
    private LocalDateTime dateOfPayment;
}
