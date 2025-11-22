//package data.repositories;
//
//import data.lastma-app.data.models.data.Ticket;
//import lastma-app.TicketNotFound;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import trafficSystem.data.models.Ticket;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TicketsTest {
//    private TicketsRepository tickets;
//    @BeforeEach
//    public void setUp(){
//        tickets = new Tickets();
//    }
//
//    @AfterEach
//    public void tearDown(){
//        tickets.deleteALL();
//    }
//
//
//    @Test
//    @DisplayName("test that I don't have any Offender")
//    public void no_tickest(){
//        assertEquals(0,tickets.count());
//    }
//
//    @Test
//    @DisplayName("test that when i add ticket")
//    public void addTicket(){
//        Ticket ticket = new Ticket();
//        tickets.save(ticket);
//        assertEquals(tickets.count(),1);
//    }
//
//    @Test
//    @DisplayName("test that when i add a ticket")
//    public void add_find_byId(){
//        Ticket ticket = new Ticket();
//        Ticket savedTickets = tickets.save(ticket);
//        assertEquals(ticket.getId(),savedTickets.getId());
//    }
//
//
//    @Test
//    @DisplayName("test that when i add two tickets i can get both id")
//    public void addTwo_Ticket(){
//        Ticket ticket1 = new Ticket();
//        Ticket ticket2 = new Ticket();
//        tickets.save(ticket1);
//        tickets.save(ticket2);
//        assertEquals(tickets.count(),2);
//    }
//
//    @Test
//    @DisplayName("test when i add two vehicles i can find by id")
//    public void find_byId(){
//        Ticket ticket1 = new Ticket();
//        Ticket ticket2 = new Ticket();
//        tickets.save(ticket2);
//        Ticket savedTicket = tickets.save(ticket1);
//        assertEquals(tickets.findById(ticket1.getId()),savedTicket);
//    }
//
//
//    @Test
//    @DisplayName("test that when i update my ticket")
//    public void update_oldTicket(){
//        Ticket ticket2 = new Ticket();
//        tickets.save(ticket2);
//        assertEquals(tickets.count(),1);
//        tickets.save(ticket2);
//        assertEquals(tickets.count(),1);
//    }
//
//    @Test
//    @DisplayName("test that i can delete by ticket id")
//    public void delete_by_Id(){
//        Ticket ticket2 = new Ticket();
//        tickets.save(ticket2);
//        tickets.deleteById(ticket2.getId());
//        assertEquals(0,tickets.count());
//    }
//
//    @Test
//    @DisplayName("test that when i delete a ticket i can not find in my id")
//    public void delete_find(){
//        Ticket ticket2 = new Ticket();
//        tickets.save(ticket2);
//        tickets.deleteById(ticket2.getId());
//        assertEquals(null,tickets.findById(ticket2.getId()));
//    }
//
//    @Test
//    @DisplayName("test when i tried deleting an invalid ticket")
//    public void test_delete_withWrong(){
//        Ticket ticket2 = new Ticket();
//    }
//
//    @Test
//    @DisplayName("test when i tried deleting with a ticket")
//    public void test_delete_vehicle(){
//        Ticket ticket2 = new Ticket();
//        tickets.save(ticket2);
//        tickets.delete(ticket2);
//        assertEquals(0, tickets.count());
//    }
//
//
//
//
//
//
//
//
//}