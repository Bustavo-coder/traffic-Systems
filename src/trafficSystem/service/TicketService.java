package trafficSystem.service;


import trafficSystem.dtos.requests.*;
import trafficSystem.dtos.response.*;

import java.util.ArrayList;

public interface TicketService {
    BookTicketResponse bookTicket(BookTicketsRequest request);
    ArrayList<ViewTicketResponse> viewTickets(String request);
    SettleTicketResponse settleTicket(SettleTicketRequest request);
}
