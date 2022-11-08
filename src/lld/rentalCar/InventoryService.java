package lld.rentalCar;

import lld.rentalCar.entity.Address;
import lld.rentalCar.entity.Store;
import lld.rentalCar.entity.User;
import lld.rentalCar.entity.Vehicle;

import java.util.*;

public class InventoryService {

    static List<Store> stores = new ArrayList<>();
    static Queue<User> users= new LinkedList<>();
    static Map<Integer, List<Store>> zipCodeWiseStore = new HashMap<>();

    public static void fillBasicData() {

        Address s1Add = new Address("GURGOAN", "HR", 122008, "8A");

        Vehicle vehicle = new Vehicle("TIYAGO", "TATA", 2019);
        Vehicle vehicle2 = new Vehicle("I10", "HYUNDAI", 2019);
        Vehicle vehicle3 = new Vehicle("ALTO", "MARUTI", 2020);
        Vehicle vehicle4 = new Vehicle("HEXA", "TATA", 2021);
        List<Vehicle> vehicleList = new ArrayList() {{
            add(vehicle);
            add(vehicle2);
            add(vehicle4);
            add(vehicle3);
        }};
        Store s1 = new Store("STORE1", vehicleList, s1Add);

        Address store2Address = new Address("DELHI", "DELHI", 122001, "1A");
        Vehicle s2V1 = new Vehicle("TIYAGO-2", "TATA", 2019);
        Vehicle s2V2 = new Vehicle("I20-2", "HYUNDAI", 2019);
        Vehicle s2V3 = new Vehicle("WAGNOR", "MARUTI", 2020);
        Vehicle s2V4 = new Vehicle("PUNCH", "TATA", 2021);
        List<Vehicle> s2VL = new ArrayList() {{
            add(s2V1);
            add(s2V2);
            add(s2V3);
            add(s2V4);
        }};
        Store s2 = new Store("STORE2", s2VL, store2Address);

        Address store4Address = new Address("OUTER", "DELHI", 122001, "2A");
        Vehicle s4V1 = new Vehicle("TIYAGO-4", "TATA", 2009);
        Vehicle s4V2 = new Vehicle("I20-4", "HYUNDAI", 2012);
        Vehicle s4V3 = new Vehicle("WAGNOR-4", "MARUTI", 2010);
        Vehicle s4V4 = new Vehicle("PUNCH-4", "TATA", 2021);
        List<Vehicle> s4VL = new ArrayList() {{
            add(s4V1);
            add(s4V2);
            add(s4V3);
            add(s4V4);
        }};
        Store s4 = new Store("STORE4", s4VL, store4Address);

        Address s3Address = new Address("GURGOAN", "HR", 122004, "1A");
        Vehicle s3V1 = new Vehicle("TIYAGO-3", "TATA", 2019);
        Vehicle s3V2 = new Vehicle("I10-3", "HYUNDAI", 2019);
        Vehicle s3V3 = new Vehicle("ALTO-3", "MARUTI", 2020);
        Vehicle s3V4 = new Vehicle("HEXA-3", "TATA", 2021);
        List<Vehicle> s3VehicleList = new ArrayList() {{
            add(s3V1);
            add(s3V4);
            add(s3V3);
            add(s3V2);
        }};
        Store s3 = new Store("STORE5", s3VehicleList, s3Address);


        Address s5Address = new Address("GURGOAN", "HR", 122005, "5A");
        Store s5 = new Store("STORE5", null, s5Address);




        stores.add(s1);
        stores.add(s2);
        stores.add(s3);
        stores.add(s4);
        stores.add(s5);

        createCache(s2, s1, s3, s4,s5);

    }

    private static void createCache(Store... stores) {
        for (Store s1:stores) {
            List<Store> t1=  zipCodeWiseStore.getOrDefault(s1.getAddress().getZipcode(), new ArrayList<>());
            t1.add(s1);
            zipCodeWiseStore.put(s1.getAddress().getZipcode(),t1);
        }
    }

    public static void addSomeUser() {
        User u1= new User("vipul",42);
        users.add( new User("U2",22));
        users.add( new User("U3",33));
        users.add( new User("U4",44));
        users.add( new User("U5",26));
        users.add( new User("U6",32));
        users.add(u1);
    }
}
