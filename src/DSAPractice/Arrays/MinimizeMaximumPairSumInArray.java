package DSAPractice.Arrays;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
    public static void main(String[] args) {
        int [] nums = {3,5,4,2,4,6};
        System.out.println(minPairSum(nums));
    }
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maximumSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length/2; i++) {
            maximumSum = Math.max(maximumSum,nums[i]+nums[nums.length-i-1]);
        }
        return maximumSum;
    }
}
