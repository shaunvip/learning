package lld.ParkingLot.entity;

import lld.rentalCar.entity.BaseEntity;

public class Vehicle extends BaseEntity {
    private String regNumber;

    private VehicleType type;

    public Vehicle(String regNumber,VehicleType type) {
       this.regNumber=regNumber;
        this.type = type;
    }
    public VehicleType getType() {
        return type;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                " " + type +" "+regNumber+
                '}';
    }
}
enum VehicleType {
    CAR,BIKE,TRUCK,BUS,SUV
}
