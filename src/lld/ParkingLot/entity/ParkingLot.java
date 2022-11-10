package lld.ParkingLot.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    Map<FLOOR, Map<LotType, List<Space>>> floorMap= new HashMap<>();
    private Address address;

    public ParkingLot(Map<FLOOR, Map<LotType, List<Space>>> floorMap, Address address) {
        this.floorMap = floorMap;
        this.address = address;
    }
}
enum FLOOR{
    ONE,TWO
}
enum LotType{
    BIG,SMALL,LARGE,XLARGE;

    public int getPricePerHour(LotType type,int hour){
     int price;
      switch (type) {
          case BIG:
              price= hour * 20;
          break;
          case SMALL:
              price= hour * 10;
          break;
          case LARGE:
              price= hour * 50;
          break;
          case XLARGE:
              price= hour * 100;
              break;
          default:
              return -1; // can throw exception
      }
      return price;
    }
}
