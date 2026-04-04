package DSAPractice.Arrays;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

public class MinimumPlatForm {
    public static void main(String[] args) {
     int arr[] = {900, 940, 950, 1100, 1500, 1800};
     int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(new Date());
        System.out.println(findPlatform(arr,dep,arr.length));
    }
    static int findPlatform(int arr[], int dep[], int n)
    {
        int requredPlatForm = 1;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 1,j = 0;
        while(i < n) {
            if(arr[i] < dep[j]) {
                requredPlatForm++;
                i++;
            }else {
                i++;
                j++;
            }
        }
        return requredPlatForm;
    }
}
