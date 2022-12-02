package arr;

import java.util.Arrays;

//There are two sorted arrays A and B of size m and n respectively. Find the median of the
//two sorted arrays. The overall run time complexity should be O(log (m+n)).
//nput:  A[] = {1, 4, 5}, B[] = {2, 3}
//Output: 3
//Explanation:
//Merging both the arrays and arranging in ascending:
//[1, 2, 3, 4, 5]
//Hence, the median is 3
//
//Input: A[] = {1, 2, 3, 4}, B[] = {5, 6}
//Output: 3.5
//Explanation:
//Union of both arrays:
//{1, 2, 3, 4, 5, 6}
//Median = (3 + 4) / 2 = 3
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        calculateMedian(new int[]{1, 4, 5},new int[] {2, 3,6});
        calculateMedian(new int[]{1, 4, 7},new int[] {2, 3,5,6});
        //Efficient Approach (Using binary search)
        calculateMedian(new int[]{1, 4, 5},new int[] {2, 3,5,6});
    }

    private static void calculateMedian(int[] a1, int[] b1) {
        int[] c= new int[a1.length+ b1.length];
        int a1c=0,b1c=0;
        int i=0;
        while (a1c<a1.length && b1c <b1.length){
            if (a1[a1c]>b1[b1c]){
                c[i++]=b1[b1c++];
            }else {
                c[i++]=a1[a1c++];
            }
        }
        while (a1c<a1.length){
            c[i++]=a1[a1c++];
        }  while (b1c<b1.length){
            c[i++]=b1[b1c++];
        }
        System.out.println(Arrays.toString(c));
        System.out.println(c.length%2==0?c[c.length/2]-1:c[c.length/2]);
    }
}
