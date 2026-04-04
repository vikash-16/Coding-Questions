package DSAPractice.Greedy;

import java.util.Arrays;

public class MaximumElementAfterDecreasingandRearranging {
    public static void main(String[] args) {
        int []arr = {2,2,1,2,1};
        System.out.println(new MaximumElementAfterDecreasingandRearranging().maximumElementAfterDecrementingAndRearranging(arr));
    }
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int count = 1;
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] >= count+1) count++;
        }
        return count;
    }
}
