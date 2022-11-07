package arr;

public class EqualSubArray {
    public static void main(String[] args) {

        String str = "1538023";
        int length = str.length();
        int ans = 0;
        for (int i = 0; i < length; i++) {
            String temp = str.substring(i, str.length()); ///
            int tempAns = backtrack(temp, i, length);
            ans = Math.max(tempAns, ans);
            System.out.println(ans);
        }
    }

    static int backtrack(String str, int start, int end) {  // 1538023 //538023
        int max = 0;
        for (int step = start + 1; step < end ; step += 2) {

            String subStrLen = str.substring(start,step+1); // 1538  // finding length??
            int left = 0, right = 0;

            for (int j = 0; j < subStrLen.length() / 2; j++) {
                left += Integer.parseInt(String.valueOf(subStrLen.charAt(j)));
                right += Integer.parseInt(String.valueOf(subStrLen.charAt(subStrLen.length() - j-1)));
                if (left == right)
                    if (max < (subStrLen.length()))
                        max = subStrLen.length();
            }

        }

        return max;
    }



}
