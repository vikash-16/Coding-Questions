package DSAPractice.DP;

import java.util.Arrays;

public class PartitionArrayforMaximumSum {
    public static void main(String[] args) {
        int [] arr = {1,15,7,9,2,5,10};
        int k = 3;
        System.out.println(new PartitionArrayforMaximumSum().maxSumAfterPartitioning(arr,k));
    }
    int [] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return dfs(0,arr,k);
    }

    private int dfs(int start, int[] arr, int k) {
        if(start >= arr.length) return 0;
        if(dp[start] != -1) return dp[start];
        int maxEle = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for(int i = start; i < Math.min(start+k,arr.length); i++) {
            maxEle = Math.max(maxEle, arr[i]);
            maxSum = Math.max(maxSum,maxEle*(i-start+1)+dfs(i+1,arr,k));
        }
        return dp[start] = maxSum;
    }
}
