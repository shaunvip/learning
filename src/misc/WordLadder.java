package misc;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 Given two words (start and end), and a dictionary, find the length of shortest transformation
 sequence from start to end, such that only one letter can be changed at a time
 and each intermediate word must exist in the dictionary. For example, given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 One shortest transformation is "hit" ->"hot" ->"dot" ->"dog" ->"cog", the program
 should return its length 5.

 */
public class WordLadder {
    public static void main(String[] args) {
       String  start = "hit";
      String  end = "cog";
       Set<String> dict =new HashSet<>(){{ add("hot");add("dot");add("dog");add("lot");add("log");}};


    }
}
