package DP;

import java.util.Arrays;
import java.util.HashMap;

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        int res = largestPerimeter(new int[]{2, 1, 2});
        System.out.println(res);
        res = largestPerimeter(new int[]{1, 2, 1});
        System.out.println(res);
        //Input: arr[ ] = {12, 5, 3, 10, 4, 8, 10, 12, -6, -1}, N = 10, K = 6
        System.out.println(subArraysWithAverageK(new int[]{12, 5, 3, 10, 4, 8, 10, 12, -6, -1},6));
        System.out.println(countKAverageSubarrays(new int[]{12, 5, 3, 10, 4, 8, 10, 12, -6, -1},10,6));
    }

    private static int subArraysWithAverageK(int[] nums, int k) {
        System.out.println(Arrays.toString(nums));
        int res=0;
        for (int i = 0; i < nums.length; i++) {
        int sum=0;
            for (int j = i; j < nums.length ; j++) {
                sum+=nums[j];
                int len = (j - i + 1);

                if (sum % len==0){
                    int avg=sum/len;
                    if (avg==k) res++;
                }
            }
            
        }
        return res;
    }
    static int countKAverageSubarrays(int[] arr, int n,int k)
    {
        int result = 0, curSum = 0;
        // Store the frequency of prefix sum of the array arr[]
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
        for(int i = 0; i < n; i++)
        {
            // Subtract k from each element, then add it to curSum
            curSum += (arr[i] - k);
            // If curSum is 0 that means sum[0...i] is 0 so increment res
            if (curSum == 0)
                result++;
            // Check if curSum has occurred before and if it has occurred before, add it's frequency to res
            if (mp.containsKey(curSum))
                result += mp.get(curSum);
            // Increment the frequency of curSum
            if(mp.containsKey(curSum))
                mp.put(curSum, mp.get(curSum) + 1);
            else
                mp.put(curSum, 1);
        }

        return result;
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i > 1; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2])
                return nums[i] + nums[i - 1] + nums[i - 2];
        }
        return 0;
    }
}

