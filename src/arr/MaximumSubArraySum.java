package arr;

import java.util.Arrays;

//https://www.interviewbit.com/blog/maximum-subarray-sum/
//Input: [-3, -4, 5, -1, 2, -4, 6, -1]
//Output: 8
//Explanation: Subarray [5, -1, 2, -4, 6] is the max sum contiguous subarray with sum 8.
public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] ints=new int[]{-3, -4, 5, -1, 2, -4, 6, -1};
        int res=getMaxSum( ints);
        System.out.println(" Max Sum "+res);
        // Maximum product of continious array
        System.out.println(getMaxProd( new int[]{-1,-2,-4}));
        System.out.println(getMaxProd( ints));
        System.out.println(getMaxProd( new int[]{2,3,-2,4}));
        System.out.println(getProductOfArrayExceptItSelf( new int[]{1,2,3,4}));
        System.out.println(getProductOfArrayExceptItSelfWEM( new int[]{1,2,3,4}));
        System.out.println(getProductOfArrayExceptItSelf( new int[]{2,3,-2,4}));
    }

    private static int getProductOfArrayExceptItSelfWEM(int[] ints) {
        int[] res=new int[ints.length];
        res[0]=1;
        // Left Part in same array
        for (int i = 1; i < ints.length; i++) {
            res[i]=ints[i-1]*res[i-1];
        }
        System.out.println(Arrays.toString(res));
        // right sub Part
        int right=1;
        for (int i = ints.length-1; i >=0 ; i--) {
            res[i]=res[i]*right;
            right=right*ints[i];
        }
        System.out.println(Arrays.toString(res));
        return 1;

    }
    private static int getProductOfArrayExceptItSelf(int[] ints) {
        int[] prefix=new int[ints.length];
        int[] postfix=new int[ints.length];
        prefix[0]=1;
        for (int i = 1; i < ints.length; i++) {
                prefix[i]=prefix[i-1]*ints[i-1];
        }
        postfix[ints.length-1]=1;
        for (int i = ints.length-2; i >= 0; i--) {
                postfix[i]=postfix[i+1]*ints[i+1];
        }
        for (int i = 0; i < ints.length; i++) {
            ints[i]=postfix[i]*prefix[i];

        }
        return 1;
    }

    private static int getMaxProd(int[] arr) {
        int max= Arrays.stream(arr).max().getAsInt();
        int cuMax=1, cuMin=1;
        for (int a: arr) {
            if (a==0){
                cuMax=cuMin=1;
            }
            int temp=cuMax*a;
            cuMax= Math.max( Math.max(a*cuMax,a*cuMin),a);
            cuMin=Math.min(Math.min(temp,a*cuMin),a);
            max=Math.max(max,cuMax);
        }
        return max;
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
