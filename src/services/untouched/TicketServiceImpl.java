package services.untouched;

import data.models.Ticket;
import data.repositories.Tickets;
import data.repositories.TicketsRepository;

import static services.untouched.RegisterTicketMapper.map;

public class TicketServiceImpl  implements  TicketsService{
    private TicketsRepository repository = new Tickets();
    @Override
    public RegisterTicketResponse registerTickets(RegisterTicketRequest request) {
        Ticket ticket = map(request);
        repository.save(ticket);
        return new RegisterTicketResponse();
    }
}
