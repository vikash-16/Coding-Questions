package DSAPractice.Arrays;

import java.util.HashSet;
import java.util.Set;

public class PythaGorianTriplet {
    public static void main(String[] args) {
     int arr[] = {3, 2, 4, 6, 5};
        System.out.println(checkTriplet(arr,arr.length));
    }
    static boolean checkTriplet(int[] arr, int n) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            arr[i] = arr[i]*arr[i];
            set.add(arr[i]);
        }
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(set.contains(arr[i]+arr[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
