package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordProblem {
    public static void main(String[] args) {
        WordProblem wordProblem= new WordProblem();
        List<String> str= new ArrayList<String>(){{
            add("aaaa");
            add("aaa");
        }};
        System.out.println( wordProblem.wordBreak("aaaaaaa",str));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        // put all words into a hashset
        Set<String> set = new HashSet<>(wordDict);
        return wb(s, set);
    }
    private boolean wb(String s, Set<String> set) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int i = 1; i <= len; ++i) {
            if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
}
