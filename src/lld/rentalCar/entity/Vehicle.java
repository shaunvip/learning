package lld.rentalCar.entity;

public class Vehicle extends BaseEntity{
    private String name;
    private String model;
    private int year;
    private VehicleType type;
    private Store store;

    public Vehicle(String name, String model, int year) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.type = VehicleType.CAR;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public VehicleType getType() {
        return type;
    }

    public Store getStore() {
        return store;
    }
}
enum VehicleType {
    CAR,BIKE,TRUCK
}
