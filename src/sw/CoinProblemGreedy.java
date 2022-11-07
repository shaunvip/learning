package sw;

import java.util.Arrays;

public class CoinProblemGreedy {
    public static void main(String[] args) {
        int[] coins={5,1,2,10};
        Arrays.sort(coins);
        int amt=57;
        int needed= coinsNeeded(coins, amt);
        System.out.println(needed);
         needed= coinsNeeded(coins, 52);
        System.out.println(needed);
    }

    private static int coinsNeeded(int[] coins, int amt) {
        int needed=0;
        for (int i = coins.length-1; i >= 0; i--) {
            if (amt >= coins[i]){
                int red= (int) Math.floor(amt / coins[i]);
                amt = amt -(coins[i]*red);
                needed +=red;
            }
        }
        return needed;
    }
}
