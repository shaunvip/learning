package misc;

import java.util.TreeMap;

public class MyCalendarThree {
    TreeMap<Integer,Integer> map;
    public MyCalendarThree() {
        map= new TreeMap<>();
    }

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree= new MyCalendarThree();
        myCalendarThree.book(10,20);
        myCalendarThree.book(50,60);
        myCalendarThree.book(10,40);
        myCalendarThree.book(5,10);
        myCalendarThree.book(5,15);
        myCalendarThree.book(25,55);
    }
    public int book(int start, int end) {
        map.put(start ,map.getOrDefault(start,0)+1);
        map.put(end ,map.getOrDefault(end,0)-1);
        int max = 0;
        int sum = 0;
        for(int key : map.keySet()){
            sum += map.get(key);
            max = Math.max(max,sum);
        }
        System.out.println(max);
        return 1;
    }
}
