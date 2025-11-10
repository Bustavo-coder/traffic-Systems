package data.repositories;

import data.models.Vehicle;
import exceptions.VehicleNotFound;
import exceptions.VehicleNotRegisterd;

import java.util.ArrayList;
import java.util.List;

public class Vehicles implements VehicleRepository{
    private int count;
    List<Vehicle> vehicles = new ArrayList<>();
    @Override
    public Vehicle save(Vehicle vehicle) {
        if(isNewCar(vehicle)) {
            if (findFirstNullPosition() != -1) saveNewVehiclesToNullPosition(vehicle);
            else addNewVehicles(vehicle);
        }

        return vehicle;
    }


    @Override
    public Vehicle findById(int id) {
        validateUserId(id);
        return vehicles.get(reduceUserIdByOne(id));
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public void deleteById(int id) {
        validateUserId(id);
        vehicles.get(reduceUserIdByOne(id)).setId(0);
        setDeletedVehiclePositionToNull(reduceUserIdByOne(id));
        count--;
    }

    @Override
    public void deleteALL() {
        vehicles.clear();
    }

    @Override
    public void delete(Vehicle vehicle) {
        int id = vehicle.getId();
        deleteById(id);
    }

    @Override
    public long count() {
        return count;
    }


    private int generateID(){
        return count + 1;
    }


    private void isNull(int vehicleId){
        if (vehicles.get(vehicleId) == null) throw new VehicleNotFound("Vehicle Not Available");
    }

    private void setDeletedVehiclePositionToNull(int id){
        vehicles.set(id,null);
    }

    private int reduceUserIdByOne(int id){
        return id -1 ;
    }

    private void validateUserId(int id){
        if (id < 1 || id > count) throw new VehicleNotRegisterd("Vehicle Is Not Yet Registered");
    }

    private int findFirstNullPosition(){
        return vehicles.indexOf(null);
    }

    private void saveNewVehiclesToNullPosition(Vehicle vehicle){
        vehicle.setId(findFirstNullPosition()+1);
        vehicles.set(findFirstNullPosition(),vehicle);
        count++;
    }
    private void addNewVehicles(Vehicle vehicle){
        vehicle.setId(generateID());
        vehicles.add(vehicle);
        count++;
    }

    private Boolean isNewCar(Vehicle vehicle){
        return vehicle.getId() == 0;
    }



}



