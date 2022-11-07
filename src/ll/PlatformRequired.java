package ll;

import java.util.Arrays;

public class PlatformRequired {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        Arrays.sort(arr);
        Arrays.sort(dep);
        int platformNeeded=1,result=1;
        int arrvl=1,dept=0;
        while (arrvl<arr.length && dept<arr.length){
            if (arr[arrvl]<=dep[dept]){
                platformNeeded++;
                arrvl++;
            } else if (arr[arrvl]>dep[dept]) {
                platformNeeded--;
                dept++;
            }

            if (platformNeeded>result){
                result=platformNeeded;
            }
        }
        System.out.println(result);
    }
}
