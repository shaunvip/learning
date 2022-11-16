package lld.ParkingLot.entity;

import java.time.LocalDateTime;

public class Reservation extends BaseEntity {
    private Vehicle vehicle; // already initiated on  property
    private User user;
    private Space space;
    private LocalDateTime tillTime;
    ReservationStatus status;

    public Reservation(Vehicle vehicle, User user, Space space) {
        this.vehicle = vehicle;
        this.user = user;
        this.space = space;
        this.status=ReservationStatus.SCHEDULED;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public LocalDateTime getTillTime() {
        return tillTime;
    }

    public void setTillTime(LocalDateTime tillTime) {
        this.tillTime = tillTime;
    }
}
enum ReservationStatus{
    SCHEDULED,BOOKED,EXPIRED,COMPLETED
}
