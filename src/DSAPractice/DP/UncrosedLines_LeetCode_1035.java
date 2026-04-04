package DSAPractice.DP;

public class UncrosedLines_LeetCode_1035 {
    public static void main(String[] args) {
       int [] nums1 = {3,2};
       int [] nums2 = {2,2,2,3};
        System.out.println(maxUncrossedLines(nums1,nums2));
    }
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int dp[][] = new int [m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    if (nums1[i] == nums2[j]) {
                        dp[i][j] = 1;
                    }
                }else if(i == 0) {
                    if(nums1[i] == nums2[j]) {
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i][j-1];
                    }
                }else if(j == 0) {
                    if(nums1[i] == nums2[j]) {
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }else {
                    if(nums1[i] == nums2[j]) {
                        dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                    }else {
                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
}
