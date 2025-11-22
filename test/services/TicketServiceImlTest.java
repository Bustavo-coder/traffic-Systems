//package test.services;
//
//import org.junit.jupiter.api.Assertions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Import;
//import trafficSystem.Main;
//import trafficSystem.data.models.Officer;
//import trafficSystem.data.models.Vehicle;
//import trafficSystem.data.repositories.OfficerRepository;
//import trafficSystem.data.repositories.TicketsRepository;
//import trafficSystem.data.repositories.VehicleRepository;
//import trafficSystem.dtos.requests.BookTicketsRequest;
//import trafficSystem.dtos.requests.RegisterOfficerRequest;
//import trafficSystem.dtos.requests.RegisterVehicleRequest;
//import trafficSystem.service.*;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//@SpringBootTest(classes = Main.class)
//public class TicketServiceImlTest {
//    @Autowired
//    private TicketService ticketService ;
//    @Autowired
//    private TicketsRepository ticketsRepository;
//    @Autowired
//    private OfficerService officerService ;
//    @Autowired
//    private OfficerRepository officerRepository;
//    @Autowired
//    private VehicleServices vehicleServices;
//    @Autowired
//    private VehicleRepository vehicleRepository;
//
//    @Test
//    public void check(){
//        RegisterVehicleRequest request = new RegisterVehicleRequest();
//        request.setVehicleChassisNumber("1122222");
//        vehicleServices.registerVehicle(request);
//        RegisterOfficerRequest registerOfficerRequest = new RegisterOfficerRequest();
//        registerOfficerRequest.setNin("12223333");
//        officerService.registerOfficer(registerOfficerRequest);
//        Officer officer = officerRepository.findByNin("12223333").isPresent() ? officerRepository.findByNin("12223333").get() : null;
//        Vehicle vehicle = vehicleRepository.findBychassisNumber("1122222").isPresent() ? vehicleRepository.findBychassisNumber("1122222").get() : null;
//        BookTicketsRequest request1 = new BookTicketsRequest();
//        Assertions.assertNotNull(officer);
//        request1.setOfficerId(officer.getId());
//        Assertions.assertNotNull(vehicle);
//        request1.setVehicleId(vehicle.getId());
//        request1.setOffenceName("ONE_WAY");
//        ticketService.bookTicket(request1);
//        assertEquals(1, ticketsRepository.count());
//
//
//
//    }
//
//}
////@Test
////@DisplayName("test when i an unregistered Officer wants to issue ticket")
////public void UnRegistered_Officer(){
////    BookTicketsRequest request2 = new BookTicketsRequest();
////    request2.setVehicleId(1);
////    request2.setOffenceName("ONE_WAY");
////    request2.setOfficerId(200);
////
////    assertThrows(OfficerNotFound.class,()->ticketService.bookTicket(request2));
////    assertEquals(0, ticketsRepository.count());
////    Vehicle offenderVehicle = vehicleRepository.findById(1);
////    assertEquals(0, offenderVehicle.getTickets().size());
////}
////
////
////@Test
////@DisplayName("When i tried booking an unregistered_car")
////public  void unregistered_car(){
////    BookTicketsRequest request2 = new BookTicketsRequest();
////    request2.setVehicleId(10000000);
////    request2.setOffenceName("ONE_WAY");
////    request2.setOfficerId(1);
////
////    assertThrows(VehicleNotRegisterd.class,()->ticketService.bookTicket(request2));
////    assertEquals(0, ticketsRepository.count());
////    Vehicle offenderVehicle = vehicleRepository.findById(1);
////    assertEquals(0, offenderVehicle.getTickets().size());
////}
////
////
////@Test
////public void viewAvailableTickets(){
////    BookTicketsRequest ticketRequest = new BookTicketsRequest();
////    ticketRequest.setVehicleId(1);
////    ticketRequest.setOffenceName("ONE_WAY");
////    ticketRequest.setOfficerId(1);
////    ticketService.bookTicket(ticketRequest);
////
////    ViewTicketRequest viewTicketRequest = new ViewTicketRequest();
////    viewTicketRequest.setVehicleId(1);
////    ticketService.viewTickets(viewTicketRequest);
////}
////
////
////@Test
////@DisplayName("test that i can settle a ticket")
////public void settleTicket(){
////    BookTicketsRequest ticketRequest = new BookTicketsRequest();
////    ticketRequest.setVehicleId(1);
////    ticketRequest.setOffenceName("ONE_WAY");
////    ticketRequest.setOfficerId(1);
////    ticketService.bookTicket(ticketRequest);
////
////    SettleTicketRequest settleTicketRequest = new SettleTicketRequest();
////    settleTicketRequest.setTicketId(1);
////    settleTicketRequest.setOffenceFee(45_000);
////    settleTicketRequest.setTicketId(1);
////    settleTicketRequest.setVehicleId(1);
////    ticketService.settleTicket(settleTicketRequest);
////    assertTrue(ticketsRepository.findById(1).getPaymentStatus());
////
////}
////
////@Test
////@DisplayName("test that when the amount i paid is not the same amount of the offence fee")
////public void test_wrong_amount(){
////    BookTicketsRequest ticketRequest = new BookTicketsRequest();
////    ticketRequest.setVehicleId(1);
////    ticketRequest.setOffenceName("ONE_WAY");
////    ticketRequest.setOfficerId(1);
////    ticketService.bookTicket(ticketRequest);
////
////    SettleTicketRequest settleTicketRequest = new SettleTicketRequest();
////    settleTicketRequest.setTicketId(1);
////    settleTicketRequest.setOffenceFee(25_000);
////    settleTicketRequest.setTicketId(1);
////    settleTicketRequest.setVehicleId(1);
////    assertThrows(InvalidOffenceFee.class,()->ticketService.settleTicket(settleTicketRequest));
////    assertFalse(ticketsRepository.findById(1).getPaymentStatus());
////}
////
////@Test
////@DisplayName("test when the ticket has been settled i cannot pay")
////public void test(){
////    BookTicketsRequest ticketRequest = new BookTicketsRequest();
////    ticketRequest.setVehicleId(1);
////    ticketRequest.setOffenceName("ONE_WAY");
////    ticketRequest.setOfficerId(1);
////    ticketService.bookTicket(ticketRequest);
////
////    SettleTicketRequest settleTicketRequest = new SettleTicketRequest();
////    settleTicketRequest.setTicketId(1);
////    settleTicketRequest.setOffenceFee(45_000);
////    settleTicketRequest.setTicketId(1);
////    settleTicketRequest.setVehicleId(1);
////    ticketService.settleTicket(settleTicketRequest);
////    assertTrue(ticketsRepository.findById(1).getPaymentStatus());
////    var vehicle = vehicleRepository.findById(1);
////    assertTrue(vehicle.getTickets().get(0).isSettled());
////
////
////    assertThrows(PaidTicketExceptions.class,()-> ticketService.settleTicket(settleTicketRequest));
////
////}