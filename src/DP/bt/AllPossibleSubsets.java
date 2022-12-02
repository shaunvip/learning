package DP.bt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPossibleSubsets {
    public static void main(String[] args) {
        int[] arr={3,4,5};
        List<List<Integer>> result= new ArrayList<>();
        Set<Integer> set= new HashSet<>();
        getAllPossibleCombinations(arr, new ArrayList<>(),result,set);
        result.forEach(System.out::println);
        getAllPossibleCombinations("hel".toCharArray(), new ArrayList<>(), new HashSet<>());
        System.out.println("DUPLICATE");
        int[] visited= new int[5];
        getAllPossibleCombinationsDuplicate("heLlo".toCharArray(), new ArrayList<>(), visited);

        result= new ArrayList<>();
        getAllPossibleSubsets(arr, new ArrayList<>(),result,0);
      //  result.forEach(System.out::println);

    }

    private static void getAllPossibleCombinationsDuplicate(char[] arr, ArrayList<Character> temp, int[] visited) {
        if (visited.length==temp.size()){
            System.out.println(temp);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]==0){
                visited[i]=1;
                temp.add(arr[i]);
                getAllPossibleCombinationsDuplicate(arr,temp,visited);
                visited[i]=0;
                temp.remove(temp.size()-1);
            }
        }
    }


    private static void getAllPossibleCombinations(char[] arr, ArrayList<Character> temp, Set<Character> set) {
        if (temp.size()==arr.length){
            System.out.println(temp);
            return;
        }
        for (char ch : arr) {
            if (!set.contains(ch)) {
                set.add(ch);
                temp.add(ch);
                getAllPossibleCombinations(arr, temp, set);
                set.remove(ch);
               temp.remove(temp.size() - 1);
            }
        }
    }
    private static void getAllPossibleCombinations(int[] arr, ArrayList<Integer> temp, List<List<Integer>> result, Set<Integer> set) {
            if (temp.size() == arr.length ) {
                result.add(new ArrayList<>(temp));
                return;
            }

        for (int j : arr) {
            if (!set.contains(j)) {
                set.add(j);
                temp.add(j);
                getAllPossibleCombinations(arr, temp, result, set);
                set.remove(j);
                temp.remove(temp.size() - 1);
            }
        }

    }

    private static void getAllPossibleSubsets(int[] arr, ArrayList<Integer> integers, List<List<Integer>> result,int start ) {
        if (start==arr.length){
           result.add(new ArrayList<>(integers));
            return;
        }
        getAllPossibleSubsets(arr,integers,result,start+1);
        integers.add(arr[start]);
        getAllPossibleSubsets(arr,integers,result,start+1);
        integers.remove(integers.size()-1);
    }
}