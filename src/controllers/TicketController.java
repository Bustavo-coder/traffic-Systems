package controllers;

import dtos.requests.BookTicketsRequest;
import dtos.requests.SettleTicketRequest;
import dtos.requests.ViewTicketRequest;
import dtos.response.BookTicketResponse;
import dtos.response.SettleTicketResponse;
import dtos.response.ViewTicketResponse;
import services.TicketService;
import services.TicketServiceIml;

import java.util.ArrayList;

public class TicketController {
    private static final TicketService ticketService = new TicketServiceIml();
   public BookTicketResponse bookTicket(BookTicketsRequest request){
       return ticketService.bookTicket(request);
   };
    public ArrayList<ViewTicketResponse> viewTickets(ViewTicketRequest request){
        return viewTickets(request);
    };
    public SettleTicketResponse settleTicket(SettleTicketRequest request){
        return ticketService.settleTicket(request);
    };

}
