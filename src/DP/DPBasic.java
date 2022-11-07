package DP;

import java.util.Arrays;
import java.util.HashSet;

public class DPBasic {
    public static void main(String[] args) {
        System.out.println(" >>  "+longestConsecutiveSubsequence(new int[]{10,11,23,22,24,14,25,12,26,13}));
        System.out.println("2 >>  "+longestConsecutiveSubsequence2(new int[]{10,11,23,22,24,14,25,12,26,13}));
        System.out.println(" >>  "+longestConsecutiveSubsequence(new int[]{4,1,3,9,2,8}));
        System.out.println("2 >>  "+longestConsecutiveSubsequence2(new int[]{4,1,3,9,2,8}));
        System.out.println();
        System.out.println(longestCommonSubSequence("axyz","baz"));
        System.out.println(longestCommonSubSequenceRec("axyz","baz"));
        System.out.println(Arrays.toString(calculateFib(10)));
    }

    private static int longestConsecutiveSubsequence2(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : arr) {
            set.add(a);
        }
        int count = 0;
        for (Integer e : set) {
            if (!set.contains(e - 1)) {

                int temp = 1;
                while (set.contains(e + temp)) {
                    temp++;
                }
                count = Math.max(temp, count);
            }
        }
        return count;
    }

    //
    private static int longestConsecutiveSubsequence(int[] arr) {
        Arrays.sort(arr);
        int count=1;
        int temp=1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]==arr[i-1]+1){
                temp++;
            }else{
                count= Math.max(count, temp);temp=0;
            }
        }
        count= Math.max(count, temp);
        return count;
    }

    private static int longestCommonSubSequenceRec(String s1, String s2) {


        return 0;
    }

    private static int longestCommonSubSequence(String s1, String s2) {

        int[][] dp= new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i < s2.length(); i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0]=0;
        }
        for (int i = 1; i <=s1.length() ; i++) {
            for (int j = 1; j <=s2.length() ; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    private static int[] calculateFib(int num) {
        int[] dp =new int[num+1];
        dp[1]=1;
        for (int i = 2; i < num; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp;
    }
}
