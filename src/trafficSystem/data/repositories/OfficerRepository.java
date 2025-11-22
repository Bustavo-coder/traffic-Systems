package trafficSystem.data.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import trafficSystem.data.models.Officer;


import java.util.Optional;
@Repository
public interface OfficerRepository extends MongoRepository<Officer,String>{

    Optional<Officer> findByNin(String nin);
}
