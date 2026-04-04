package DSAPractice.DP;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
       int [] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1) return n;
        int [] dp = new int[n];
        dp[0] = 1;
        int len;
        for(int i  = 1; i < n; i++) {
            len = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    len = Math.max(len,dp[j]);
                }
            }
            dp[i] = len+1;
        }
        len = 1;
        for(int i = 0; i< n; i++) {
            len = Math.max(len,dp[i]);
        }
        return len;
    }
}
