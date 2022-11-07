package DP;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Item{
    int wt;
    int value;

    public Item(int wt, int value) {
        this.wt = wt;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" + "wt=" + wt +
                ", value=" + value +
                '}';
    }
}
class ActivityCmp implements Comparator<Item>{
    @Override
    public int compare(Item i1,Item i2){
        return i1.value*i2.wt- i2.value* i1.wt;
    }
}
public class FractionalKnapSack {
    public static void main(String[] args) {
        List<Item> items= new ArrayList<>();
        items.add(new Item(10,60));
        items.add(new Item(40,40));
        items.add(new Item(20,100));
        items.add(new Item(30,120));
        items.add(new Item(50,50));
        items.sort(new ActivityCmp().reversed());
        items.forEach(System.out::println);
        getKnapSack(items,50);
    }

    private static void getKnapSack(List<Item> items, int w) {
        double knap=0;
        for (int j = 0; j < items.size(); j++) {
            if (items.get(j).wt<=w){
                knap+=items.get(j).value;
                w=w-items.get(j).wt;
            } else if (w>0) {
                Item ci=items.get(j);
                knap+= w*((double) ci.value/ci.wt);
                w=0;
            }else break;
        }
        System.out.println(knap);
    }
}
