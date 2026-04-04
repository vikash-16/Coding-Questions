package DSAPractice.DP;

import java.util.Arrays;

public class HouseRobberII {
    public static void main(String[] args) {
        int [] nums = {1,2};
        System.out.println(new HouseRobberII().rob(nums));
    }
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(robHelper(nums,0,nums.length-2),robHelper(nums,1,nums.length-1));
    }

    private int robHelper(int[] nums, int strat, int end) {
        int[] arr = Arrays.copyOfRange(nums, strat, end + 1);
        if(arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];
        int []dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i = 2; i <arr.length; i++) {
            dp[i] = Math.max(dp[i-1],arr[i]+dp[i-2]);
        }
        return dp[arr.length-1];
    }
}
