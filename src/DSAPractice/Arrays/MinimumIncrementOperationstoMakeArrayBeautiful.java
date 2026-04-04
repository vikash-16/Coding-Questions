package DSAPractice.Arrays;

import java.util.HashMap;

public class MinimumIncrementOperationstoMakeArrayBeautiful {
    public static void main(String[] args) {
        int []  nums = {0,1,3,3};
        int k = 5;
        System.out.println(new MinimumIncrementOperationstoMakeArrayBeautiful().minIncrementOperations(nums,k));
    }
    public long minIncrementOperations(int[] nums, int k) {
        int [] dp = new int[nums.length];
        dp[0] = Math.max(0,k-nums[0]);
        dp[1] = Math.max(0,k-nums[1]);
        dp[2] = Math.max(0,k-nums[2]);
        for(int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(0,k-nums[i])+Math.min(dp[i-1],Math.min(dp[i-2],dp[i-3]));
        }
        return Math.min(dp[nums.length-1],Math.min(dp[nums.length-2],dp[nums.length-3]));
    }


}
