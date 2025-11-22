package trafficSystem.data.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import trafficSystem.data.models.Vehicle;


import java.util.Optional;
@Repository
public interface VehicleRepository extends MongoRepository<Vehicle,String> {

    Optional<Vehicle> findBychassisNumber(String chassisNumber);

}
