package Jul20;

public class SlidingWindow {
    public static void main(String[] args) {
        callme(new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20},4);
    }

    private static int callme(int[] nums, int ele) {
        if (nums.length < ele) {
            return 0;
        }
        int totalSum = nums[0];
        for (int i = 1; i < ele; i++) {
            totalSum += nums[i];
        }

        return totalSum;
    }
}
