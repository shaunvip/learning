package lld.rentalCar;

import lld.rentalCar.entity.*;

import java.time.LocalDateTime;
import java.util.List;

public class RentalCarApplication {
    public static void main(String[] args) {
        initiateData();
        User user = InventoryService.users.poll();
        initiateBooking(user,122001);
        initiateBooking(InventoryService.users.poll(),23453);
    }

    private static void initiateBooking(User user,int zipCode) {

        List<Store> stores = searchVehicleAtZip(zipCode);
        if (stores == null || stores.isEmpty()) {
            System.err.print("NO VEHICLE AVAILABLE AT ZIP ");
            return;
        }
        Vehicle vehicle = stores.get(0).getVehicleList().get(0);
        Booking booking = new Booking(LocalDateTime.now(), LocalDateTime.now().plusDays(5), vehicle, user);
        Payment payment = new Payment(booking);
        System.out.println("BOOKING REPORT " + payment);

    }

    private static List<Store> searchVehicleAtZip(int zipCode) {
        return InventoryService.zipCodeWiseStore.get(zipCode);

    }

    private static void initiateData() {
        InventoryService.fillBasicData();
        InventoryService.addSomeUser();
    }
}
