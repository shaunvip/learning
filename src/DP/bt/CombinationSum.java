package DP.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum= new CombinationSum();
        List<List<Integer>> re= combinationSum.combinationSum(new int[]{2,3,4,8},8);
        re.forEach(System.out::println);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> mainList, ArrayList<Integer> newList, int[] nums, int start) {
        mainList.add(new ArrayList<>(newList));
        System.out.printf("start %d , end %d, newList %s \n",start,nums.length, newList);
        for (int i = start; i < nums.length ; i++) {
            System.out.printf("Adding to list %d  ",nums[i]);
            newList.add(nums[i]);
            backtrack(mainList, newList, nums, i + 1);
            System.out.printf(" \t Remove %d ",newList.get(newList.size()-1));
            newList.remove(newList.size()-1);
            System.out.printf(" \t  list %s \n\n",newList);

        }
    }
}
