package sw;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "start=" + start + ", end=" + end ;

    }

    @Override
    public int compareTo(Pair o) {
        return this.end-o.end;
    }
}
public class ActivitySelectionGreedy {
    public static void main(String[] args) {
        List<Pair> list= new ArrayList<>();
        list.add(new Pair(2,3));
        list.add(new Pair(1,4));
        list.add(new Pair(5,8));
        list.add(new Pair(6,10));
        PriorityQueue<Pair> pairs = new PriorityQueue<>(list);
        list.clear();
        list.addAll(pairs);
        pairs.clear();
        for (int i = 0; i < list.size()-1; i++) {
            Pair cp= list.get(i);
            Pair np=list.get(i+1);
            if (cp.end< np.start){
                System.out.println(" "+cp);
            }else {
                System.out.println("Ignoring "+np);
            }
        }

    }
}
