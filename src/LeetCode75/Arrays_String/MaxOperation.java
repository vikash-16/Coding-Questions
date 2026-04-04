package LeetCode75.Arrays_String;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxOperation {
    public static void main(String[] args) {
        int i = new MaxOperation().maxOperations(new int[]{1, 2, 3, 4}, 5);
        System.out.println(i);
    }
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int low = 0, high = nums.length-1;
        while(low < high) {
            int sum = nums[low] + nums[high];
            if(sum == k) {
                low++;
                high--;
                count++;
            }else if(sum < k) {
                low++;
            }else {
                high--;
            }
        }
        return count;
    }
}
