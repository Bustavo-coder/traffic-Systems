package services;

import dtos.requests.BookTicketsRequest;
import dtos.requests.SettleTicketRequest;
import dtos.requests.ViewTicketRequest;
import dtos.response.SettleTicketResponse;
import dtos.response.ViewTicketResponse;
import dtos.response.BookTicketResponse;

public interface TicketService {
    BookTicketResponse bookTicket(BookTicketsRequest request);
    ViewTicketResponse viewTickets(ViewTicketRequest request);
    SettleTicketResponse settleTicket(SettleTicketRequest request);
}
