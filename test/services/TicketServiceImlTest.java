//import data.lastma-app.data.models.data.Vehicle;
//import data.repositories.*;
//import dtos.requests.*;
//import lastma-app.InvalidOffenceFee;
//import lastma-app.OfficerNotFound;
//import lastma-app.PaidTicketExceptions;
//import lastma-app.VehicleNotRegisterd;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TicketServiceImlTest {
//    private TicketService ticketService;
//    private VehicleServices vehicleServices;
//    private OfficerService officerService;
//    private TicketsRepository ticketsRepository;
//    private OfficerRepository officerRepository;
//    private VehicleRepository vehicleRepository;
//
//    private RegisterVehicleRequest vehicleRequest;
//    private RegisterOfficerRequest officerRequest;
//
//
//    @BeforeEach
//    public void setUp(){
//        vehicleServices = new VehicleServiceImpl();
//        officerService = new officerServiceImpl();
//
//        officerRepository = new Officers();
//        vehicleRepository = new Vehicles();
//        ticketsRepository = new Tickets();
//
//        ticketService = new TicketServiceIml(vehicleRepository,officerRepository,ticketsRepository);
//
//
//        vehicleRequest = new RegisterVehicleRequest();
//        vehicleRequest.setVehicleChassisNumber("123222");
//        vehicleServices.registerVehicle(vehicleRequest);
//
//        officerRequest = new RegisterOfficerRequest();
//        officerRequest.setNin("123456789");
//        officerService.registerOfficer(officerRequest);
//
//    }
//
//    @AfterEach
//    public void tearDown(){
//        officerRepository.deleteALL();
//        vehicleRepository.deleteALL();
//        ticketsRepository.deleteALL();
//    }
//
//
//    @Test
//    @DisplayName("test that  can issue a ticket for a registered vehicle by a registered officer")
//    public void issueTicket(){
//
//        BookTicketsRequest request2 = new BookTicketsRequest();
//        request2.setVehicleId(1);
//        request2.setOffenceName("ONE_WAY");
//        request2.setOfficerId(1);
//        ticketService.bookTicket(request2);
//
//        assertEquals(ticketsRepository.count(),1);
//
//    }
//
//
//
//    @Test
//    @DisplayName("test that when issue a ticket for a vehicle the vehicle nowhas ticket")
//    public void vehicleTicket(){
//        BookTicketsRequest request2 = new BookTicketsRequest();
//        request2.setVehicleId(1);
//        request2.setOffenceName("ONE_WAY");
//        request2.setOfficerId(1);
//        ticketService.bookTicket(request2);
//
//        assertEquals(1, ticketsRepository.count());
//
//        Vehicle offenderVehicle = vehicleRepository.findById(1);
//        assertEquals(1, offenderVehicle.getTickets().size());
//
//    }
//
//    @Test
//    @DisplayName("test when i an unregistered Officer wants to issue ticket")
//    public void UnRegistered_Officer(){
//        BookTicketsRequest request2 = new BookTicketsRequest();
//        request2.setVehicleId(1);
//        request2.setOffenceName("ONE_WAY");
//        request2.setOfficerId(200);
//
//        assertThrows(OfficerNotFound.class,()->ticketService.bookTicket(request2));
//        assertEquals(0, ticketsRepository.count());
//        Vehicle offenderVehicle = vehicleRepository.findById(1);
//        assertEquals(0, offenderVehicle.getTickets().size());
//    }
//
//
//    @Test
//    @DisplayName("When i tried booking an unregistered_car")
//    public  void unregistered_car(){
//        BookTicketsRequest request2 = new BookTicketsRequest();
//        request2.setVehicleId(10000000);
//        request2.setOffenceName("ONE_WAY");
//        request2.setOfficerId(1);
//
//        assertThrows(VehicleNotRegisterd.class,()->ticketService.bookTicket(request2));
//        assertEquals(0, ticketsRepository.count());
//        Vehicle offenderVehicle = vehicleRepository.findById(1);
//        assertEquals(0, offenderVehicle.getTickets().size());
//    }
//
//
//    @Test
//    public void viewAvailableTickets(){
//        BookTicketsRequest ticketRequest = new BookTicketsRequest();
//        ticketRequest.setVehicleId(1);
//        ticketRequest.setOffenceName("ONE_WAY");
//        ticketRequest.setOfficerId(1);
//        ticketService.bookTicket(ticketRequest);
//
//        ViewTicketRequest viewTicketRequest = new ViewTicketRequest();
//        viewTicketRequest.setVehicleId(1);
//        ticketService.viewTickets(viewTicketRequest);
//    }
//
//
//    @Test
//    @DisplayName("test that i can settle a ticket")
//    public void settleTicket(){
//        BookTicketsRequest ticketRequest = new BookTicketsRequest();
//        ticketRequest.setVehicleId(1);
//        ticketRequest.setOffenceName("ONE_WAY");
//        ticketRequest.setOfficerId(1);
//        ticketService.bookTicket(ticketRequest);
//
//        SettleTicketRequest settleTicketRequest = new SettleTicketRequest();
//        settleTicketRequest.setTicketId(1);
//        settleTicketRequest.setOffenceFee(45_000);
//        settleTicketRequest.setTicketId(1);
//        settleTicketRequest.setVehicleId(1);
//        ticketService.settleTicket(settleTicketRequest);
//        assertTrue(ticketsRepository.findById(1).getPaymentStatus());
//
//    }
//
//    @Test
//    @DisplayName("test that when the amount i paid is not the same amount of the offence fee")
//    public void test_wrong_amount(){
//        BookTicketsRequest ticketRequest = new BookTicketsRequest();
//        ticketRequest.setVehicleId(1);
//        ticketRequest.setOffenceName("ONE_WAY");
//        ticketRequest.setOfficerId(1);
//        ticketService.bookTicket(ticketRequest);
//
//        SettleTicketRequest settleTicketRequest = new SettleTicketRequest();
//        settleTicketRequest.setTicketId(1);
//        settleTicketRequest.setOffenceFee(25_000);
//        settleTicketRequest.setTicketId(1);
//        settleTicketRequest.setVehicleId(1);
//        assertThrows(InvalidOffenceFee.class,()->ticketService.settleTicket(settleTicketRequest));
//        assertFalse(ticketsRepository.findById(1).getPaymentStatus());
//    }
//
//    @Test
//    @DisplayName("test when the ticket has been settled i cannot pay")
//    public void test(){
//        BookTicketsRequest ticketRequest = new BookTicketsRequest();
//        ticketRequest.setVehicleId(1);
//        ticketRequest.setOffenceName("ONE_WAY");
//        ticketRequest.setOfficerId(1);
//        ticketService.bookTicket(ticketRequest);
//
//        SettleTicketRequest settleTicketRequest = new SettleTicketRequest();
//        settleTicketRequest.setTicketId(1);
//        settleTicketRequest.setOffenceFee(45_000);
//        settleTicketRequest.setTicketId(1);
//        settleTicketRequest.setVehicleId(1);
//        ticketService.settleTicket(settleTicketRequest);
//        assertTrue(ticketsRepository.findById(1).getPaymentStatus());
//        var vehicle = vehicleRepository.findById(1);
//        assertTrue(vehicle.getTickets().get(0).isSettled());
//
//
//        assertThrows(PaidTicketExceptions.class,()-> ticketService.settleTicket(settleTicketRequest));
//
//    }
//
//
//
//}