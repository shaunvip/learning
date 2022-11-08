package lld.rentalCar.entity;

import java.util.List;

public class Store extends BaseEntity{
    private String name;
    private List<Vehicle> vehicleList;
    private Address address;

    public String getName() {
        return name;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public Address getAddress() {
        return address;
    }

    public Store(String name, List<Vehicle> vehicleList, Address address) {
        this.name = name;
        this.vehicleList = vehicleList;
        this.address = address;
    }
}
