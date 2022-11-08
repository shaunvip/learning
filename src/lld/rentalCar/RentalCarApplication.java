package lld.rentalCar;

import lld.rentalCar.entity.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RentalCarApplication {
    public static void main(String[] args) throws InterruptedException {
        initiateData();
        User user = InventoryService.users.poll();
        initiateBooking(user,122001);
        initiateBooking(InventoryService.users.poll(),23453);
        searchCarAtZip(122001);
        searchCarAtZip(122009);
        searchCarAtZip(122005);
    }

    private static void searchCarAtZip(int zipCode) {
      System.out.printf("Cars at zip %d \n",zipCode);
      List<Store> stores= InventoryService.zipCodeWiseStore.get(zipCode);
      if (stores==null || stores.isEmpty()){
          System.err.println("NO VEHICLES AVAILABE "+zipCode);
          return;
      }
     List<Vehicle> vehicleList=stores.stream().flatMap(s->s.getVehicleList().stream()).collect(Collectors.toList());
      if (vehicleList.isEmpty()) {
          System.err.println("NO VEHICLES AVAILABE "+zipCode);
          return;
      }
      vehicleList.forEach(System.out::println);
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
