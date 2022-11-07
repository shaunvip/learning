package str;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LargestNumberInKSwap {
    //from string  make largest number in k swap
    // 1234567 // 4 // 7654321
    // 3435335   // 3 // 5543333
    public static void main(String[] args) {
        System.out.println("3435335");
        String str= findMax("3435335",3);
        System.out.println(str);
    }

    private static String findMax(String s,int k) {
        String response="";
        char[] chars=s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int jpos=0;
            for (int j=i+1; j < chars.length;j++) {
                if (chars[j]>chars[i]) {
                    char temp=chars[i];
                    chars[i]=chars[jpos];
                    chars[jpos]=temp;
                    k--;
                }
            }
                System.out.println("Array now "+ Arrays.toString(chars));

            if (k==0)
                break;
        }
        System.out.println(chars);
       return response;
    }
}
