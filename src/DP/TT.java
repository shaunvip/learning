package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TT {
    public static void main(String[] args) {
        Integer[] arr={1,2,3,4,5,6,11,17,19,34};
        List<Integer> al= Arrays.asList(arr);
       // find_max_apples(5,al);
        List<List<Integer>> result= new ArrayList<>();
         getAllPossibleSubsets(arr,new ArrayList<>(),result,0,5);
         result.forEach(System.out::println);
        // 13 12 10 5 6 6 0 0 12 0 0 0
        Integer[] arr2={12,13, 12 ,10, 5, 6, 6, 0, 0, 12, 0 ,0, 0};
        balance_water(Arrays.asList(arr2));


    }
    public static int balance_water(List<Integer> elements) {
        int arrs=elements.get(0);
        for (Integer integer : elements) {
            System.out.print(" "+integer);
        }
        List<Integer> capacity= elements.subList(1, 5);
        List<Integer> initial= elements.subList(5, 9);
        List<Integer> finalC= elements.subList(9, 13);
        
        return 1;
    }
    private static void getAllPossibleSubsets(Integer[] arr, ArrayList<Integer> integers, List<List<Integer>> result, int start, int sum) {
        if (start==arr.length){
            result.add(new ArrayList<>(integers));
            return;
        }
        getAllPossibleSubsets(arr,integers,result,start+1, sum);
        integers.add(arr[start]);
        getAllPossibleSubsets(arr,integers,result,start+1, sum);
        integers.remove(integers.size()-1);
    }
    public static int find_max_apples(int max_size_difference, List<Integer> apple_sizes) {
        System.out.println(max_size_difference);
        Collections.sort(apple_sizes);
        int result=0;
        boolean resLeft=true;
        for(int i=0;i<apple_sizes.size();i++){
            System.out.println(apple_sizes.get(i));
            for(int j=i;j<apple_sizes.size();j++){
System.out.println("     "+(apple_sizes.get(j)-apple_sizes.get(i)));
if(apple_sizes.get(j)-apple_sizes.get(i)==max_size_difference){
    System.out.println("         "+(apple_sizes.get(j)+" "+apple_sizes.get(i)));
    result++;
    resLeft=false;
}else{
    resLeft=true;

}
            }
        }
        return resLeft? result+1:result;
    }
}
