package sw;

import java.util.Arrays;

public class GroupAll1Together {
    public static void main(String[] gh) {
        int[] arr={0,1,1,1,0,0,1,1,0};
       int totalOne=0;
        int len = arr.length;
        for (int c:arr) {
            if (c==1) totalOne++;
        }
        if (len == totalOne || totalOne == 0)
            System.out.println("ZERO");
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int k = 0; k < totalOne; k++) {
            if (arr[k] == 0)
                count++;
        }
        min = Math.min(min, count);

        for (int i=1; i < len; i++) {
            int j = (i + totalOne - 1) % len;
            System.out.println("j "+j);
            if (arr[j] == 0 && arr[i - 1] == 1) {
                System.out.println("SWAP");
                count++;
            }
            else if (arr[j] == 1 && arr[i - 1] == 0)
                count--;
            min = Math.min(min, count);
        }
        System.out.println(min);
    }
}
