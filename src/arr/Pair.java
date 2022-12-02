package arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pair {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 3, -6, 9, 11, 7};
        int sum = 4;
        findPairs(arr, sum);
        findPairsBetter(arr, sum);
        Triplet t = new Triplet();

        t.triplets(arr, 15);
    }

    private static void findPairsBetter(int[] arr, int sum) {
        System.out.println("findPairsBetter");
        Set<Integer> set = new HashSet<>();
        for (Integer c : arr) {
            int temp = sum - c;
            if (set.contains(c)) {
                System.out.printf("CAN BE FOUND %d  %d", c, temp);
            }
            set.add(temp);
        }
    }

    private static void findPairs(int[] arr, int sum) {

        for (int i = 0; i < arr.length; i++) {
            int tempSum = sum;
            tempSum -= arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - tempSum == 0) {
                    System.out.printf("FOUND for  %d %d", arr[i], arr[j]);
                    break;
                }
            }
        }
        System.out.println();
    }
}

class Triplet {

    public void triplets(int[] arr, int sum) {
        System.out.println(" \nTriplets " + Arrays.toString(arr) + " " + sum);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int c = arr[i];
            int tempSum=sum;
                tempSum-=c;
            for (int j = i + 1; j < arr.length; j++) {
               int num2=arr[j];
                int temp = tempSum - num2;
                if (set.contains(temp)) {
                    System.out.printf("CAN BE FOUND %d  %d", c, temp);
                }
                set.add(num2);
            }
            set.add(c);
        }
    }
}
