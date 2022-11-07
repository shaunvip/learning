package DP;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {


        String str = "ADOBECODEBANC";
        String str2 = "ABC";
        findMinimumWindow(str,str2);
    }

    private static void findMinimumWindow(String str, String str2) {

    int res=    findMinimumWindow(str,str2,str.length(),str2.length());
        System.out.println(res);

    }

    private static int findMinimumWindow(String str, String str2, int strLen, int str2Len) {
        if (str.length()==0 || str2.length()==0){
            return 0;
        }
        if (str.charAt(strLen-1)==str2.charAt(str2Len-1)){

            return 1+Math.max(findMinimumWindow(str,str2,strLen-1,str2Len),findMinimumWindow(str,str2,strLen,str2Len-1));
        }
        return 0;
    }
}
