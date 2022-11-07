package arr;

public class FindnthMagicnumber {
    public static void main(String[] args) {
        System.out.println(getNthMagic(5));
    }

    private static int getNthMagic(int n) {
        int pow=1;
        int ans=0;
        while (n!=0){
            pow=pow*5;
            if ((n & 1) == 1)
              ans += pow;
            n>>=1;
            System.out.println(n);
        }
        return ans;
    }
}
