package str;

import java.util.HashSet;
import java.util.Set;

public class LongestDisChar {
    public static void main(String[] args) {
        longestString("qwertyuioplkjh");
        longestString("okmnijnhbtgv");
        System.out.println();
        System.out.println(15>>2);
        System.out.println(29>>3);
        System.out.println(29<<3);
        // 1 1 1 1 0
        //
        System.out.println();
        lenOfLongSubarr(new int[]{-3,-16,-17,-1,-2,8,-4,9,-17,18,16,-6,-17,-8,15,0,11,2,15},19,11);
      //  lenOfLongSubarr(new int[]{-14,10, -15, 17, 4, 18, 3, -18, -7, -4, -8, 8,-8},13,12);
        // lenOfLongSubarr(new int[]{10, 5, 2, 7, 1, 9},6,15);
        //  lenOfLongSubarr(new int[]{17},1,17);


    }

    public static int lenOfLongSubarr (int A[], int N, int K) {
        int maxLen=0;
        for (int i = 0; i < N; i++) {
            int sum=A[i];
            if (sum==K){
                maxLen=Math.max(maxLen,1);
               // continue;

            }
            for (int j = i+1; j <N ; j++) {
             //   System.out.println( " adding now "+A[j]+" SUM "+(sum+A[j]));
                sum=sum+A[j];
                if (sum==K){
                    maxLen=Math.max(maxLen,(j-(i-1)));
                    System.out.println("max len"+maxLen+" i is "+A[i]);
                }
            }
        }
        System.out.println("OUT"+maxLen);
        return maxLen;
    }
    private static void longestString(String str) {
        Set<Character> visited= new HashSet<>();
        Set<String> list= new HashSet<>();
        int maxlen=0;
        for (int i = 0; i < str.length()-1; i++) {
          //  System.out.print(str.charAt(i));
            for (int j = i; j < str.length(); j++) {
                char ch= str.charAt(j);
                if (visited.contains(ch)) {
                    String temp = str.substring(i, j);
                    list.add(temp);
                    maxlen = Math.max(maxlen, temp.length());
                    visited.clear();
                    break;
                }
                visited.add(ch);
            }
            maxlen = Math.max(maxlen, visited.size());
            visited.clear();
        }
        if(maxlen==0)
            maxlen= str.length();
        System.out.println(maxlen);
       // System.out.println(list);
    }
}
