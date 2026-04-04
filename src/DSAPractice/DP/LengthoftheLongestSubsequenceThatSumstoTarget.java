package DSAPractice.DP;

import java.util.Arrays;
import java.util.List;

public class LengthoftheLongestSubsequenceThatSumstoTarget {
    public static void main(String[] args) {
        List<Integer>nums = List.of(1,1,5,4,5);
        int target = 3;
        System.out.println(new LengthoftheLongestSubsequenceThatSumstoTarget().lengthOfLongestSubsequence(nums,target));
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int [][]dp = new int[n+1][target+1];
        for(int i = 0; i < n+1;i++) {
            Arrays.fill(dp[i],-1);
            for(int j = 0; j < target+1; j++) {
                if(j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < target+1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums.get(i - 1) && dp[i - 1][j - nums.get(i - 1)] != -1)
                    dp[i][j] = Math.max(1 + dp[i - 1][j - nums.get(i - 1)], dp[i][j]);
            }
        }
        return dp[nums.size()][target];
    }
}
