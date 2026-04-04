package DSAPractice.DP;

import java.util.Arrays;

public class KInversePairsArray {
    public static void main(String[] args) {
        int n = 3,k = 1;
        System.out.println(new KInversePairsArray().kInversePairs(n,k));
    }
    int mod = 1000000007;
    public int kInversePairs(int n, int k) {
        if(k <= 0) {
            return k == 0 ? 1 : 0;
        }
        int [][] dp = new int[1001][1001];
        dp[0][0] = 1;
        for(int N = 1; N <= n; ++N) {
            for(int K = 0; K <= k; ++K) {
                for(int i = 0; i <= Math.min(N-1,K); ++i) {
                    dp[N][K] = (dp[N][K]+dp[N-1][K-i])%mod;
                }
            }
        }
        return dp[n][k];
    }
}
