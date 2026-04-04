package DSAPractice.DP;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coin = {1,2,5};
        int amount = 11;
        System.out.println(new CoinChange().coinChange(coin,amount));
    }
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]> amount ? -1 : dp[amount];
    }
}
