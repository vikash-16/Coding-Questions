package DSAPractice.DP;

import DSAPractice.Tree.MinimumDepthOfBinaryTree;

public class MinCostClimbStairs {
    public static void main(String[] args) {
        int [] cost = {10,15,20};
        System.out.println();
        System.out.println(new MinCostClimbStairs().minCostClimbingStairs(cost));
    }
    public int minCostClimbingStairs(int[] cost) {
        int [] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-2],dp[i-1])+cost[i];
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}
