package lld.rentalCar.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Store extends BaseEntity{
    private String name;
    private List<Vehicle> vehicleList;
    private Address address;

    public String getName() {
        return name;
    }

    public List<Vehicle> getVehicleList() {
        return Optional.ofNullable(vehicleList).orElse(new ArrayList<>());
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
