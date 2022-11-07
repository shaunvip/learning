package arr;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Bit {
    public static void main(String[] args){

    }
        static int nof(String str){
        char[] chars= str.toCharArray();
        int len= chars.length;
        int[] freq=new int[26];
        int result=0;
            for (int i = 0; i < str.length(); i++) {
                char ch=chars[i];
                int pos=ch-97;
                freq[pos]=freq[pos]+1;
            }
            for (int i = 0; i < freq.length; i++) {
                result=Math.max(freq[i],result );
            }
            System.out.println(result);
            return result;
        }

    public static int removeDuplicates(int[] nums) {
        int index=0;
        if (nums.length==1){
            return 1;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[index++]=nums[i];
            }
        }
        if(nums[index]!=nums[nums.length-1]|| index==0){
            nums[index++]=nums[nums.length-1];
        }
        System.out.println(index);
        return index;
    }
}
