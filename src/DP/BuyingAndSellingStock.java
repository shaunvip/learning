package DP;

public class BuyingAndSellingStock {
    public static void main(String[] args) {
        getMaxProfit(new int[]{7,-1,5,-3,6,4});
    }

    private static void getMaxProfit(int[] prices) {
        int maxP=0;
        int minBuyPrice = prices[0]; // min
        int todayProfit=0;
        for (int price : prices) {
            if (price < minBuyPrice) {
                minBuyPrice = price;
            }
            todayProfit = price - minBuyPrice;
            if (maxP < todayProfit) {
                maxP = todayProfit;
            }
        }
        System.out.println(maxP+" "+minBuyPrice);
    }
}
