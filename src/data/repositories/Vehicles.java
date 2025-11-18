package data.repositories;

import data.models.Vehicle;
import java.util.HashMap;

public class Vehicles implements VehicleRepository{
    private static int count = 0;
    private static HashMap<Integer,Vehicle> listOfVehicles = new HashMap<>();


    @Override
    public Vehicle save(Vehicle vehicle) {
        registerNew(vehicle);
        listOfVehicles.put(vehicle.getId(),vehicle);
        return vehicle;
    }

    @Override
    public Vehicle findById(int id) {
//        validateId(id);
        return listOfVehicles.get(id);
    }

    @Override
    public HashMap<Integer,Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public void deleteById(int id) {
//        validateId(id);
        listOfVehicles.remove(id);


    }

    @Override
    public void deleteALL() {
        listOfVehicles.clear();
        count = 0;

    }

    @Override
    public void delete(Vehicle vehicle) {
        int id = vehicle.getId();
        deleteById(id);
    }

    @Override
    public long count() {
        return listOfVehicles.size();
    }

    @Override
    public Vehicle findByChassisNumber(String chassisNumber) {
        for(Vehicle vehicle : listOfVehicles.values()){
            if(vehicle.getChassisNumber().equals(chassisNumber)) return vehicle;
        }
        return null;
    }


    private int generateID(){
        return count + 1;
  }
  private boolean isNew(Vehicle vehicle){
        return vehicle.getId() == 0;
  }


  private void registerNew(Vehicle vehicle){
      if(isNew(vehicle)) {
          vehicle.setId(generateID());
          count++;
      }

  }

//  private void validateId(int id){
//        if(!listOfVehicles.containsKey(id))throw new VehicleNotRegisterd("Vehicle Is Not Registered");
//  }



}



