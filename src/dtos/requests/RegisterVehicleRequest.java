package dtos.requests;

import data.models.Gender;
import data.models.Owner;
import data.models.Ticket;


public class RegisterVehicleRequest {
    private String vehicleName;
    private String vehicleModel;
    private String  vehicleYearOfProduction;
    private String vehicleColor;
    private String vehiclePlateNumber;
    private String vehicleChassisNumber;
    private String ownerName;
    private String OwnerAddress;
    private String ownerPhone;
    private Gender ownerGender;
    private String ownerMail;

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleYearOfProduction() {
        return vehicleYearOfProduction;
    }

    public void setVehicleYearOfProduction(String vehicleYearOfProduction) {
        this.vehicleYearOfProduction = vehicleYearOfProduction;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public String getVehicleChassisNumber() {
        return vehicleChassisNumber;
    }

    public void setVehicleChassisNumber(String vehicleChassisNumber) {
        this.vehicleChassisNumber = vehicleChassisNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAddress() {
        return OwnerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        OwnerAddress = ownerAddress;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public Gender getOwnerGender() {
        return ownerGender;
    }

    public void setOwnerGender(Gender ownerGender) {
        this.ownerGender = ownerGender;
    }

    public String getOwnerMail() {
        return ownerMail;
    }

    public void setOwnerMail(String ownerMail) {
        this.ownerMail = ownerMail;
    }
}
