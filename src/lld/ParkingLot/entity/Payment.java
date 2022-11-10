package lld.ParkingLot.entity;

public class Payment {
    private Reservation reservation;
    PaymentStatus status;

    public Payment(Reservation reservation) {
        this.reservation = reservation;
        this.status=PaymentStatus.UNPAID;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
enum PaymentStatus{
    PAID,UNPAID,WAIVED
}
