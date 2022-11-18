package bit_manipulation;

public class Bit {
    // https://medium.com/techie-delight/bit-manipulation-interview-questions-and-practice-problems-27c0e71412e7
    public static void main(String[] args){
        System.out.println(nof("viipul"));
        System.out.println(nof("sssssdddddd"));
        removeDuplicates(new int[]{1,1,1,2,6,6});
        evenOddNumber(4);
        evenOddNumber(41);
        add1ToAnInteger(7);
    }

    private static void add1ToAnInteger(int i) {
        System.out.printf("After adding 1 to num %d res is %d ",i,(-~i));
    }

    private static void evenOddNumber(int i) {
        //4 2 1 >>  1 0 0
        //4 2 1 >>  1 0 1
        System.out.println("Number is "+ (i&1));
    }

    static int nof(String str){
        char[] chars= str.toCharArray();
            int[] freq=new int[26];
        int result=0;
            for (int i = 0; i < str.length(); i++) {
                char ch=chars[i];
                int pos=ch-97;
                freq[pos]=freq[pos]+1;
            }
            for (int j : freq) {
                result = Math.max(j, result);
            }
            System.out.println(str+"  "+result);
            return result;
        }

    public static void removeDuplicates(int[] nums) {
        int index=0;
        if (nums.length==1){
            return;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[index++]=nums[i];
            }
        }
        if(nums[index]!=nums[nums.length-1]){
            nums[index++]=nums[nums.length-1];
        }
        for (Integer s:nums) {
            System.out.print(" "+s);
        }
        System.out.println("Res "+index);
    }
}
