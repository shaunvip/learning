package str;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestDisChar {
    public static void main(String[] args) {
        longestString("okmnijnhbtgv");
        longestString("abcbbcab");
        longestStringOptimized("abcbbcab");
        longestString("qwertyuioplkjh");
        longestStringOptimized("qwertyuioplkjh");
        longestStringOptimized(new int[]{1, 1, 0, 1, 1, 1, 0, 0, 1});
        System.out.println();
        System.out.println(15>>2);
        System.out.println(29>>3);
        System.out.println(29<<3);
        System.out.println();
        lenOfLongSubarr(new int[]{-3,-16,-17,-1,-2,8,-4,9,-17,18,16,-6,-17,-8,15,0,11,2,15},19,11);



    }

    private static void longestStringOptimized(int[] ints) {
        int len=0;
        int start =0;
        System.out.print("Find Maximum Consecutive 1s in an Array:"+ Arrays.toString(ints));
        for (int anInt : ints) {
            if (anInt == 0) {
                start = 0;
            } else {
                start += 1;
                len = Math.max(start, len);
            }

        }
        System.out.println(len);
    }

    public static int lenOfLongSubarr (int[] A, int N, int K) {
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
    private static void longestStringOptimized(String str) {
        Set<Character> visited= new HashSet<>();
        int maxlen=0;
        int i=0,j=0;
        int n=str.length();
        while (i<n && j<n){
            Character ch=str.charAt(j);
            if (!visited.contains(ch)){
                visited.add(ch);
                j=j+1;
                maxlen=Math.max(maxlen,j-i);
            }else {
                visited.remove(ch);
                i=i+1;
            }
        }
        System.out.println(str+"  "+maxlen);
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
        System.out.println(str+" >> "+maxlen);
       // System.out.println(list);
    }
}
