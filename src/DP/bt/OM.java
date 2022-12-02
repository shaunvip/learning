package DP.bt;

import java.util.*;

public class OM {
   static Queue<SushiItem> queue= new LinkedList<>();
    public static void main(String[] args) {
        ArrayList<SushiOrder> request = new ArrayList<>(
                Arrays.asList(
                        new SushiOrder(1, // seatId for this order
                                new ArrayList<>(Arrays.asList(
                                        new String[] {
                                                // menuItemIds for this order
                                                "tuna", "california", "avocado"
                                        }
                                ))
                        ),
                        new SushiOrder(3,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"avocado"}
                                ))
                        ),
                        new SushiOrder(2,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {
                                                "salmon", "tuna", "crab", "scallop"
                                        }
                                ))
                        )
                )
        );
        int size= request.size();
        int ctr=0;
        request.sort(Comparator.comparingInt(SushiOrder::getSeatId));
        while (true){
            if (!request.isEmpty()){
                if (request.get(ctr).getMenuItemIds().size()>0) {
                    queue.add(new SushiItem(request.get(ctr).getSeatId(), request.get(ctr).getMenuItemIds().get(0)));
                    request.get(ctr).getMenuItemIds().remove(0);
                    if (request.get(ctr).getMenuItemIds().isEmpty()){
                        request.remove(ctr);
                        size--;
                    }
                }
                ctr++;
            }else {
                break;
            }
            if (ctr>=(size)){
                ctr=0;
            }
        }
        System.out.println(queue);
    }

}

class SushiOrder{
    public SushiOrder(int seatId, List<String> menuItemIds) {
        this.seatId = seatId;
        this.menuItemIds = menuItemIds;
    }

    int id;
    int seatId;
    List<String> menuItemIds = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public List<String> getMenuItemIds() {
        return menuItemIds;
    }

    public void setMenuItemIds(List<String> menuItemIds) {
        this.menuItemIds = menuItemIds;
    }
}
class SushiItem{
    int seat;
    String name;

    public SushiItem(int seat, String name) {
        this.seat = seat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

