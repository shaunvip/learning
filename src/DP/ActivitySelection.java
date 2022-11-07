package DP;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Activity implements Comparable<Activity> {
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Activity activity){
        return activity.end-this.end;
    }

    @Override
    public String toString() {
        return "Activity{" + "start=" + start +
                ", end=" + end +
                '}';
    }
}
class MyCmp implements Comparator<Activity>{

    @Override
    public int compare(Activity o1, Activity o2) {
        return o1.end-o2.end;
    }
}
public class ActivitySelection {
    public static void main(String[] args) {
        List<Activity> list= new ArrayList<>();
        list.add(new Activity(1000,1200));
        list.add(new Activity(900,1100));
        list.add(new Activity(1130,1400));
        list.add(new Activity(1400,1500));
        list.add(new Activity(1420,1500));
        list.sort(new MyCmp());
        list.forEach(System.out::println);
        int act=1;
        int start=0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start>=list.get(start).end){
                act++;
                start=i;
            }
        }
        System.out.println("Total acti"+act);

    }
}
