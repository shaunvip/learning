package arr;


import java.util.Arrays;


public class RotateArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
       rotate(arr,3);
    }

    private static void rotate(int[] list, int distance) {
        int size = list.length;
        if (size == 0)
            return;
        distance = distance % size;
        if (distance < 0)
            distance += size;
        if (distance == 0)
            return;

        for (int cycleStart = 0, nMoved = 0; nMoved != size; cycleStart++) {
            int displaced = list[cycleStart];
            int i = cycleStart;
            do {
                i += distance;
                if (i >= size)
                    i -= size;
                 list[i]= displaced;
                 displaced=i+1;
                nMoved ++;
            } while (i != cycleStart);
        }
        System.out.println(Arrays.toString(list));
    }
}
