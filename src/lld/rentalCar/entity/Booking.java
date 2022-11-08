package lld.rentalCar.entity;


import java.time.LocalDateTime;

public class Booking extends BaseEntity{
    private LocalDateTime date;
    private LocalDateTime till;
    private Vehicle vehicle;
    private User user;
    private BookingStatus status;


    public Booking(LocalDateTime date,LocalDateTime till, Vehicle vehicle, User user) {
        this.date = date;
        this.till=till;
        this.vehicle = vehicle;
        this.user = user;
        this.status=BookingStatus.SCHEDULED;

    }

    @Override
    public String toString() {
        return "Booking{" +
                "date=" + date +
                ", till=" + till +
                ", vehicle=" + vehicle.getName() +
                ", user=" + user.getName() +
                ", status=" + status +
                '}';
    }
}
enum BookingStatus{
    SCHEDULED,CANCELLED,COMPLETED
}
