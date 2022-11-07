public class InterleavingString {
    public static void main(String[] args) {
      boolean res=  isInterleave("aabcc", "dbbca", "aadbbcbcac");

        res=  isInterleave("a", "b", "a");
        System.out.printf("res "+res);
        System.out.println("\n\n++++++++++");
        res=  isInterleave("aabcc", "dbbca", "aadbcbbcac");


        System.out.printf("res "+res);
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        // s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        int lt1=s1.length();
        int st1=0,st2=0;
        int l2=s2.length();
        boolean res=true;
        if (s3.length()!=lt1+l2){
            return false;
        }
        for(int i=0;i<s3.length();i++){
            char ch=s3.charAt(i);
            if(st1<lt1 && ch == s1.charAt(st1)){
                System.out.print(ch);
                st1++;
            }
            else if(st2<l2 && ch == s2.charAt(st2)){
                System.out.print(ch);
                st2++;
            }else{
                System.out.println("  char not matched"+ch);
                res= false;
            }
        }

        boolean res2=true;
         st1=0;
         st2=0;

        for(int i=0;i<s3.length();i++){
            char ch=s3.charAt(i);

             if(st2<l2 && ch == s2.charAt(st2)){
                System.out.print(ch);
                st2++;
            }
            else if(st1<lt1 && ch == s1.charAt(st1)){
                System.out.print(ch);
                st1++;
            }
             else{
                System.out.println("  char not matched"+ch);
                res2= false;
            }
        }
        System.out.println(res+" "+res2);
        return res|| res2;
    }
}
