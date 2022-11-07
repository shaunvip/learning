package arr;
//The first Catalan numbers for n = 0, 1, 2, 3, ... are
//
//1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786,

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * C
 *  {n}=1/{n+1} * {2n \n}
 *
 *  2n!
 *  (n+1)! * n!
 */
public class CatalanNumber {
    public static void main(String[] args) {
        catalanDP(5);
        getCaNum(5);
    }

    private static void getCaNum(int num) {
        Map<Integer ,Integer> map= new HashMap<>();
        int top=fact(num*2,map);
        int baseN1=fact(num+1,map);
        int baseN=fact(num,map);
        baseN1=baseN1*baseN;
        System.out.println(top/baseN1);
    }
    static int catalanDP(int n)
    {
        // Table to store results of subproblems
        int[] catalan = new int[n + 2];

        // Initialize first two values in table
        catalan[0] = 1;
        catalan[1] = 1;

        // Fill entries in catalan[]
        // using recursive formula
        for (int i = 2; i <= n; i++) {
            System.out.println(Arrays.toString(catalan));
            for (int j = 0; j < i; j++) {
                System.out.printf(" \n   here I %d and val %d and J %d and val %d and last %d val %d  \n",i,catalan[i],j,catalan[j],(i-j-1),catalan[i-j-1]);
                catalan[i] += catalan[j] * catalan[i - j - 1];
                System.out.println(Arrays.toString(catalan));
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(catalan));

        // Return last entry
        return catalan[n];
    }

    private static int fact(int num, Map<Integer, Integer> map) {

        if (num==1) return 1;
        return num*fact(num-1,map);
    }
}
