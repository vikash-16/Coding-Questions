package DSAPractice.DP;

public class IntegerBreak {
    public static void main(String[] args) {
        int n = 59;
        System.out.println(new IntegerBreak().integerBreak(n));
    }
    public int integerBreak(int n) {
        if(n <= 3) {
            return n-1;
        }
        int [] dp = new int[n+1];
        for(int i = 1; i <= 3; i++) {
            dp[i] = i;
        }
        for(int i = 4; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }
}
