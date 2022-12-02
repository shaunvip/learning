package str;
//Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic
//if the characters in s can be replaced to get t.
//For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(checkIsoString("egg","add"));
        checkIsomorphicStrings("badc", "baba");
        checkIsomorphicStrings2("badc", "baba");
        checkIsomorphicStrings("egg","add");
        checkIsomorphicStrings2("egg","add");
        checkIsomorphicStrings("foo","bar");
        checkIsomorphicStrings("paper", "title");
    }
    public  static  boolean checkIsoString(String a , String b){
        System.out.println("RIVISION ");
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char c1=a.charAt(i);
            char c2=b.charAt(i);
            Character ch=getKeyTemp(map,c2);
            if (ch!=null && c1!=ch){
                return false;
            }
            if (map.containsKey(c1) && map.get(c1)!=c2){
                return false;
            }else {
                map.put(c1,c2);
            }
        }
        return true;
    }
    private  static  Character getKeyTemp(Map<Character,Character> map,char ch){
        for(Map.Entry<Character,Character> ct:map.entrySet()){
            if (ct.getValue()==ch){
                return ct.getKey();
            }
        }
        return null;
    }







    private static boolean checkIsomorphicStrings2(String s1, String s2) {
        System.out.print(" \n 2 CHECKING FOR "+s1 +" AND "+s2 +" ");
        HashMap<Character,Character> map= new HashMap<>();
        if (s1.length()!=s2.length())
            return false;
        boolean flag=true;
        for (int i = 0; i < s1.length(); i++) {
            Character c1=s1.charAt(i);
            Character c2=s2.charAt(i);
             if (map.containsKey(c1)){
                if(map.get(c1)!=c2 && map.get(c2)!=c1){
                    flag=false;
                    break;
                }
            }
            else {
                map.put(c1,c2);
                map.put(c2,c1);
            }
        }
        System.out.println(flag);
        return  flag;
    }

    private static boolean checkIsomorphicStrings(String s1, String s2) {
        System.out.println(" CHECKING FOR "+s1 +" AND "+s2);
        HashMap<Character,Character> map= new HashMap<>();
        if (s1.length()!=s2.length())
            return false;
        boolean flag=true;
        for (int i = 0; i < s1.length(); i++) {
            Character c1=s1.charAt(i);
            Character c2=s2.charAt(i);
            Character c= getKey(map,c2);
           if(c!=null && c1!=c){
               flag=false;
               break;
           }
            else if (map.containsKey(c1)){
                if(map.get(c1)!=c2){
                    flag=false;
                    break;
                }
            }
            else {
               map.put(c1,c2);
            }
        }
        System.out.println(flag);
        return  flag;
    }
    public  static Character getKey(HashMap<Character,Character> map, Character target){
        for (Map.Entry<Character,Character> entry : map.entrySet()) {
            if (entry.getValue().equals(target)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
