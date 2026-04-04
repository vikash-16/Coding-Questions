package DSAPractice.DP;

import javax.net.ssl.HostnameVerifier;
import java.lang.reflect.Array;
import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int []nums = {1,2,3,1};
        System.out.println(new HouseRobber().rob(nums));
    }
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int dp[] = new int[nums.length];
        Arrays.fill(dp,0);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[nums.length-1];
    }
}
