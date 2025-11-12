package services;

import dtos.requests.BookTicketsRequest;
import dtos.response.BookTicketResponse;
import dtos.requests.RegisterOfficerRequest;
import dtos.response.RegisterOfficerResponse;

public interface adminOfficerService {
    RegisterOfficerResponse registerOfficer(RegisterOfficerRequest request);
    BookTicketResponse bookTickets(BookTicketsRequest request);
}
