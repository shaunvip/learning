package arr;

import java.util.Arrays;

/**
 * Problem Statement
 * The Longest Increasing Subsequence (LIS) problem is to find the
 * length of the longest subsequence
 * of a given sequence such that all elements of the subsequence are
 * sorted in increasing order.
 *
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6
 * and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        getLIS(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80});
        getLIS(new int[]{2,8,3,4});
        getLongestIncreasingSubsequenceCorrect(new int[]{2,6,8,3,4,5,1});
    }

    private static void getLongestIncreasingSubsequenceCorrect(int[] ints) {
        int[] temp= new int[ints.length];
        int size=0;
        for (int n:ints){
            System.out.println("checking for num "+n);
            int i=0,j=size;
            while (i!=j){
                int mid=(i+j)/2;
                System.out.println("     "+i+"<--i j "+j+" mid "+mid);
                if (temp[mid]<n){
                    i=mid+1;
                }else
                    j=mid;
            }
            temp[i]=n;
            if (i==size)++size;
            System.out.println("        temp arr + "+ Arrays.toString(temp) +"  size"+size);
        }
        System.out.println(size);
    }

    private static void getLIS(int[] arr) {
        int prev=Integer.MIN_VALUE;
        int count=0;
        for (int n:arr){
            if (n>prev){
                count++;
                prev=n;
            }
        }

        System.out.println(count);
    }
}
