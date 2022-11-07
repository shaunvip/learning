package arr;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TopKElement {
    public static void main(String[] args) {
        int parent = (2 - 1) >>> 1;
        System.out.println(parent);
        System.out.println(4>>1);
        System.out.println(4>>>1);
        System.out.println(8>>>1);
        System.out.println(10<<2);
        System.out.println(10<<1);
        System.out.println("  "+(-10>>2));
        System.out.println(-10>>>2);
        // 00001010

        //10000010
        TopKElement pq= new TopKElement();
        PriorityQueue<Integer>  mainPq= new PriorityQueue<>();
        mainPq.add(22);
        pq.add(22);
        mainPq.add(42);
        pq.add(42);
        mainPq.add(2);
        pq.add(2);
        mainPq.add(21);
        pq.add(21);
        mainPq.add(13);
        pq.add(13);
        pq.add(61);
        pq.add(111);
        pq.add(18);
        pq.add(1);
        System.out.println();

        pq.print(mainPq);
        System.out.println();
        mainPq.forEach(p->{
            System.out.print(p+" ");
        });
    }

    private void print(PriorityQueue<Integer> mainPq) {
        for (int i = 0; i < sz; i++) {
            System.out.print(queue[i]+" ");

        }
    }

    transient int[] queue= new int[10];
    int sz=0;

    private void add(int i) {
        if (sz==0)
            queue[sz++]=i;
        else
            siftUpComparable(sz,i);
    }
    //  private void siftUpComparable(int k, E x) {
    //        Comparable<? super E> key = (Comparable<? super E>) x;
    //        while (k > 0) {
    //            int parent = (k - 1) >>> 1;
    //            Object e = queue[parent];
    //            if (key.compareTo((E) e) >= 0)
    //                break;
    //            queue[k] = e;
    //            k = parent;
    //        }
    //        queue[k] = key;
    //    }
    private void siftUpComparable(int k,int x) {
        System.out.printf("Adding  %d at pos %d ",x,k);
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            int e = queue[parent];
            if (e<=k)
                break;
            queue[k] = e;
            k = parent;
        }
        sz++;
        queue[k] = x;
    }

    private static int[] findDuplicate(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] != arr[i + 1]) {
                System.out.println("val is Distinct at pos pl for "+i+"  "+arr[i]);
                arr[index++] = arr[i];
            }else {
                System.out.println(" aa "+arr[i]+" at pos"+i);
            }
        }
        System.out.println(Arrays.toString(arr));
        if (arr[index]!= arr[arr.length-1]){
            arr[index++]=arr[arr.length-1];
        }
        System.out.println(Arrays.toString(arr));
        for (int i = index; i < arr.length ; i++) {
            arr[i]=0;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
