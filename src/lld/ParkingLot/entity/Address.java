package lld.ParkingLot.entity;

import lld.rentalCar.entity.BaseEntity;

public class Address extends BaseEntity {
    private String city;
    private String state;
    private int zipcode;
    private String street;

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getStreet() {
        return street;
    }

    public Address(String city, String state, int zipcode, String street) {
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.street = street;
    }
}
