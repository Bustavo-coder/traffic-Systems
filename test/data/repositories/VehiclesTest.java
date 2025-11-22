//package data.repositories;
//
//import data.lastma-app.data.models.data.Vehicle;
//import lastma-app.VehicleNotRegisterd;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class VehiclesTest {
//    private VehicleRepository vehicles;
//    @BeforeEach
//    public void setUp(){
//        vehicles = new Vehicles();
//    }
//
//    @Test
//    @DisplayName("test that i don have any vehicle")
//    public void noVehicles(){
//        assertEquals(0,vehicles.count());
//    }
//
//    @Test
//    @DisplayName("test when i save a car")
//    public void addCar(){
//        assertEquals(0,vehicles.count());
//        Vehicle vehicle = new Vehicle();
//        vehicles.save(vehicle);
//        assertEquals(1,vehicles.count());
//    }
//
//    @Test
//    @DisplayName("test that when i add a vehicle i can find by id")
//    public void findById(){
//        Vehicle savedVehicle = new Vehicle();
//        vehicles.save(savedVehicle);
//        Vehicle expectedVehicle =  vehicles.findById(1);
//        assertEquals(savedVehicle.getId(), expectedVehicle.getId());
//    }
//
//    @Test
//    @DisplayName("When I tried Updating a new Car")
//    public void update(){
//        Vehicle savedVehicle1 = new Vehicle();
//        vehicles.save(savedVehicle1);
//        assertEquals(1,vehicles.count());
//        vehicles.save(savedVehicle1);
//        assertEquals(1,vehicles.count());
//
//    }
//
//    @Test
//    @DisplayName("add two vehicles")
//    public void addTwo_Vehicles(){
//        Vehicle savedVehicle1 = new Vehicle();
//        vehicles.save(savedVehicle1);
//        Vehicle savedVehicle2 = new Vehicle();
//        vehicles.save(savedVehicle2);
//        Vehicle expectedVehicle =  vehicles.findById(2);
//        assertEquals(savedVehicle2.getId(), expectedVehicle.getId());
//    }
//
//    @Test
//    @DisplayName("test that when i add i vehicle i can delete by id")
//    public void deleteById(){
//        Vehicle savedVehicle1 = new Vehicle();
//        vehicles.save(savedVehicle1);
//        Vehicle savedVehicle2 = new Vehicle();
//        vehicles.save(savedVehicle2);
//        assertEquals(2,vehicles.count());
//        vehicles.deleteById(savedVehicle1.getId());
//        assertEquals(1,vehicles.count());
//    }
//
//    @Test
//    @DisplayName("test that when i delete by id my vehicle is not in my vehicles")
//    public void chekVehicle_IsDeleted(){
//        Vehicle savedVehicle1 = new Vehicle();
//        vehicles.save(savedVehicle1);
//        vehicles.deleteById(savedVehicle1.getId());
//        assertEquals(null,vehicles.findById(savedVehicle1.getId()));
//    }
//
//    @Test
//    @DisplayName("test that when i tried finding a vehicle that not registered")
//    public void find_UnRegisteredVehicle(){
//        Vehicle vehicle1 = new Vehicle();
//        assertEquals(null,vehicles.findById(vehicle1.getId()));
//    }
//
//    @Test
//    @DisplayName("test that i can delete with my vehicle")
//    public void delete_WithVehicle(){
//        Vehicle savedVehicle1 = new Vehicle();
//        vehicles.save(savedVehicle1);
//        vehicles.delete(savedVehicle1);
//        assertEquals(null,vehicles.findById(savedVehicle1.getId()));
//    }
//
//    @Test
//    @DisplayName("test that when i add i vehicle i can delete by id")
//    public void findByChassisNumber(){
//        Vehicle savedVehicle1 = new Vehicle();
//        savedVehicle1.setChassisNumber("244444");
//        vehicles.save(savedVehicle1);
//        assertEquals(vehicles.findByChassisNumber("244444"),savedVehicle1);
//
//
//    }
//
//
//
//
//    @AfterEach
//    void tearDown(){
//        vehicles.deleteALL();
//    }
//
//
//
//}