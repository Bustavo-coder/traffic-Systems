package trafficSystem.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import trafficSystem.data.models.Ticket;

@Repository
public interface TicketsRepository extends MongoRepository<Ticket, String> {

}
