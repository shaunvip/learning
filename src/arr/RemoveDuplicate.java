package arr;

import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        findDuplicate(new int[]{2, 3, 3, 4, 4, 5});
    }

    private static int[] findDuplicate(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] != arr[i + 1]) {
                System.out.println("val is Distinct at pos pl for "+i+"  "+arr[i]);
                arr[index++] = arr[i];
            }else {
                System.out.println(" aa "+arr[i]+" at pos"+i);
            }
        }
        System.out.println(Arrays.toString(arr));
        if (arr[index]!= arr[arr.length-1]){
            arr[index++]=arr[arr.length-1];
        }
        System.out.println(Arrays.toString(arr));
        for (int i = index; i < arr.length ; i++) {
            arr[i]=0;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
