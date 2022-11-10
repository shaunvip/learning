package lld.ParkingLot.entity;

public class Space {
    boolean available;
    Vehicle vehicle;

    public Space(boolean available, Vehicle vehicle) {
        this.available = available;
        this.vehicle = vehicle;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
