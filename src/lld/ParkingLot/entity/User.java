package lld.ParkingLot.entity;

import lld.rentalCar.entity.BaseEntity;

public class User extends BaseEntity {
    private String name;
    private int age;
    private String drivingLicenceNumber;

    public User(String name, int age,String  drivingLicenceNumber) {
        this.name = name;
        this.age = age;
        this.drivingLicenceNumber=drivingLicenceNumber;
    }

    public String getDrivingLicenceNumber() {
        return drivingLicenceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

}
