package sw;

import java.util.Arrays;
import java.util.Comparator;

public class Maxfreq {


    public static void main(String[] args) {
        int[] arr = {6, 3, 4, 0, 2};
        Arrays.sort(arr);
        int len = arr.length - 1;
        int k = 3;
        System.out.println(Arrays.toString(arr));
        for (int i = len; i > 0; i--) {
            int ele = arr[i];
            int tempK = k;
            int feq = 0;
            for (int j = i - 1; j >= 0; j--) {
                int ce = arr[j];
                int diff = ele - ce;
                if ((tempK - diff) >= 0) {
                    tempK = tempK - diff;
                    feq++;
                } else if (((tempK - diff)) < 0) {
                    break;
                }
            }
            System.out.println("Frequency " + (k - tempK) + " " + feq);
        }
    }
}