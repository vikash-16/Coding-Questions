package DSAPractice.Arrays;

import java.util.Arrays;

public class CountTriplets {
    public static void main(String []args) {
        int [] arr = {12,8,2,11,5,14,10};
        System.out.println(countTriplet(arr,7));
    }
    static int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        int count = 0;
        for(int i = n-1; i > 1; i--) {
            int left = 0;
            int right = i-1;
            while(left < right) {
                if(arr[left]+arr[right] == arr[i]) {
                    count++;
                    left++;
                    right--;
                }else if(arr[left]+arr[right] < arr[i]) {
                    left++;
                }else{
                    right--;
                }
            }
        }
        return count;
    }
}
