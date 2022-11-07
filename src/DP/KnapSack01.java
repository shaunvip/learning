package DP;

public class KnapSack01 {
    public static void main(String[] args) {
        int[] val={50,40,120,150};
        int[] wt={10,20,40,30};
        //        5 , 2 ,3,3
        int W=50;
       int pos= solveKnapSack(val,wt,W,val.length-1);
        System.out.println(pos);
        int[] V={10,40,30,50};
        int[] WT={5,4,6,3};
        //        2, 10,5,17
        pos= solveKnapSack(V,WT,10,V.length-1);
        System.out.println(pos);
        pos= solveKnapSackTab(V,WT,10,V.length);
        System.out.println("POS "+pos);

    }

    private static int solveKnapSackTab(int[] v, int[] wt, int W, int length) {
        int[][] dp=new int[length+1][W+1];
        for (int i = 0; i <W ; i++) {
            dp[0][i]=0;

        }
        for (int i = 1; i <=length ; i++) {
            for (int j =1; j <=W ; j++) {
                if (wt[i-1]>j) {
                    dp[i][j]=dp[i-1][j];
                }else{
                     dp[i][j] = Math.max(v[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
            }
        }
        return dp[length][W];
    }

    private static int solveKnapSack(int[] val, int[] wt, int W, int length) {
        if (length<0){
            return 0;
        }
        if (wt[length]>W){
             //   System.out.printf("OHH %d, this is greater than %d \n",wt[length],W);
               return solveKnapSack(val,wt,W,length-1);
            } else {
               return   Math.max(solveKnapSack(val, wt, W, length-1), val[length]+solveKnapSack(val, wt, W-wt[length], length-1));

            }

    }
}
