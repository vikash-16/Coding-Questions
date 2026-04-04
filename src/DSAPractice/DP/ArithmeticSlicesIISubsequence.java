package DSAPractice.DP;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesIISubsequence {
    public static void main(String[] args) {
        int []nums = {2,4,6,8,10};
        System.out.println(new ArithmeticSlicesIISubsequence().numberOfArithmeticSlices(nums));
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; ++i) dp[i] = new HashMap<>();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];
                int cnt = dp[j].getOrDefault(diff, 0);
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + cnt + 1);
                ans += cnt;
            }
        }
        return ans;
    }
}
