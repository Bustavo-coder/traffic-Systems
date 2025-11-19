package services;

import dtos.requests.BookTicketsRequest;
import dtos.requests.SettleTicketRequest;
import dtos.requests.ViewTicketRequest;
import dtos.response.SettleTicketResponse;
import dtos.response.ViewTicketResponse;
import dtos.response.BookTicketResponse;

import java.util.ArrayList;

public interface TicketService {
    BookTicketResponse bookTicket(BookTicketsRequest request);
    ArrayList<ViewTicketResponse> viewTickets(ViewTicketRequest request);
    SettleTicketResponse settleTicket(SettleTicketRequest request);
}
