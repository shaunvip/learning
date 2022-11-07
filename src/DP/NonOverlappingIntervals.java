package DP;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NonOverlappingIntervals {
    /**
     * Given a collection of intervals, return a maximal set of non-overlapping intervals while prioritising the longer intervals.
     * <p>
     * input - (1,5),(2,7),(11,18)
     * output - (11, 18), (2, 7)
     */
    public static void main(String[] args) {
        PriorityQueue<Interval> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Interval(1, 5));
        priorityQueue.add(new Interval(2, 7));
        priorityQueue.add(new Interval(11, 18));
        List<Interval> list = new ArrayList<>(priorityQueue);
        list = getNonOverLapping(list);
        System.out.println();
        list.forEach(System.out::println);
    }

    private static List<Interval> getNonOverLapping(List<Interval> priorityQueue) {
        List<Interval> re = new ArrayList<>();
        Interval prev = priorityQueue.get(0);
        for (int i = 1; i < priorityQueue.size(); i++) {
            Interval current = priorityQueue.get(i);

            if (current.start > prev.end|| re.isEmpty()) {
                if (prev.diff > current.diff) {
                    re.add(prev);
                }else{
                    re.add(current);
                    prev = priorityQueue.get(i);
                }
            }
        }
        return re;
    }
}

class Interval implements Comparable<Interval> {
    int start, end;
    int diff;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
        this.diff = end - start;
    }

    @Override
    public int compareTo(Interval o) {
        return this.end - o.end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                ", diff=" + diff +
                '}';
    }
}
