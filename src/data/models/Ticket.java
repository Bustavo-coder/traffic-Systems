package data.models;

import java.time.LocalDateTime;

public class Ticket {
    private int id;
    private Vehicle vehicle;
    private Offence offence;
    private boolean hasPaid;
    private Officer issuer;
    private final LocalDateTime dateOfBooking = LocalDateTime.now();
    private LocalDateTime dateOfPayment;




}
