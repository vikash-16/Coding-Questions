package DSAPractice.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PerfecrSquare {
    public static void main(String[] args) {
        int n = 288;
        System.out.println(new PerfecrSquare().numSquares(n));
    }

    int [] dp;
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        return helper(n,dp);
    }

    private int helper(int n, int[] dp) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(dp[n] != Integer.MAX_VALUE) {
            return dp[n];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i*i <= n; i++) {
            min = Math.min(min ,helper(n-i*i,dp)+1);
        }
        return dp[n] = min;
    }
}
