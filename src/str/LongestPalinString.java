package str;

public class LongestPalinString {
    public static void main(String[] args) {
        String str = "aacabdkacaa";
        String ps = "";
        for (int i = 0; i < str.length(); i++) {
            int pos = i;
            int last = str.length() - 1;
            boolean unmatched = false;
            int index = 0;
            while (pos <= last) {
                char lastChar = str.charAt(last);// d
                if (str.charAt(pos) != lastChar) {
                    last--;
                    unmatched = false;
                    index = 0;
                }else if (str.charAt(pos) == lastChar) {
                    pos++;
                    unmatched = true;
                    index = index != 0 ? index : last;
                    last--;
                }
            }
            if (unmatched) {
                String temp = str.substring(i, index);
                System.out.println(temp);
                ps = ps.length() > temp.length() ? ps : temp;
            }
        }
        System.out.println(ps);

    }
}
