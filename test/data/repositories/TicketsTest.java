package data.repositories;

import data.models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketsTest {
    @BeforeEach
    public void setUp(){
        Tickets tickets = new Tickets();
    }

    @Test
    @DisplayName("test that I don't have any Offender")
    public void noOffender(){}

}