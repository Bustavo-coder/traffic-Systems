package data.repositories;

import data.models.Vehicle;

import java.util.List;

public interface VehicleRepository {
    Vehicle save(Vehicle vehicle);
    Vehicle findById(int id);
    List<Vehicle> findAll();
    void deleteById(int id);
    void deleteALL();
    void delete(Vehicle vehicle);
    long count();
}
