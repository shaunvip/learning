package DP.bt;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        List<List<String>> response=   partition("aab");
        response.forEach(re->re.forEach(System.out::println));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }
    public static void backtrack(List<List<String>> list,List<String> temp,String str,int pos){
        if (str.length()==pos){
            list.add(new ArrayList<>(temp));
        }
        for (int i = pos; i < str.length(); i++) {
            if (isPalindrome(str,pos,i)){
                temp.add(str.substring(pos, i + 1));
                backtrack(list,temp,str,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String str, int low, int high) {
        while (low<high){
            if (str.charAt(low++)!=str.charAt(high--))
                return false;
        }
        return true;
    }
}

