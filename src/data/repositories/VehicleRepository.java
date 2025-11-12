package data.repositories;

import data.models.Vehicle;

import java.util.HashMap;
import java.util.List;

public interface VehicleRepository {
    Vehicle save(Vehicle vehicle);
    Vehicle findById(int id);
    HashMap<Integer,Vehicle> findAll();
    void deleteById(int id);
    void deleteALL();
    void delete(Vehicle vehicle);
    long count();
    Vehicle findByChassisNumber(String chassisNumber);
}
