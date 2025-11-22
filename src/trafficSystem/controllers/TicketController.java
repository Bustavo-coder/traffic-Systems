package trafficSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trafficSystem.dtos.requests.*;
import trafficSystem.dtos.response.*;
import trafficSystem.service.TicketService;


import java.util.ArrayList;
@RestController

public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket")
   public BookTicketResponse bookTicket( @RequestBody BookTicketsRequest request){
       return ticketService.bookTicket(request);
   }

    @GetMapping("/tickets/{id}")
    public ArrayList<ViewTicketResponse> viewTickets(@PathVariable("id") String id){
        return ticketService.viewTickets(id);
    }

    @PatchMapping("/settle")
    public SettleTicketResponse settleTicket(@RequestBody SettleTicketRequest request){
        return ticketService.settleTicket(request);
    }

}
