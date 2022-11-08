package lld.rentalCar.entity;


import java.time.LocalDateTime;

public class Payment extends BaseEntity{
    private Booking booking;

    public Payment(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "booking=" + booking +
                '}';
    }
}
