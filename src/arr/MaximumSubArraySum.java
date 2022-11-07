package arr;
//https://www.interviewbit.com/blog/maximum-subarray-sum/
//Input: [-3, -4, 5, -1, 2, -4, 6, -1]
//Output: 8
//Explanation: Subarray [5, -1, 2, -4, 6] is the max sum contiguous subarray with sum 8.
public class MaximumSubArraySum {
    public static void main(String[] args) {
        int res=getMaxSum( new int[]{-3, -4, 5, -1, 2, -4, 6, -1});
        System.out.println(res);
    }

    private static int getMaxSum(int[] arr) {
        int curSum=0;
        int maxSum=Integer.MIN_VALUE;
        for (int a:arr){
            curSum+=a;
            if (curSum>maxSum){
                 maxSum=curSum;
            }
            if (curSum<0){
                curSum=0;
            }
        }
        return maxSum;
    }
}
