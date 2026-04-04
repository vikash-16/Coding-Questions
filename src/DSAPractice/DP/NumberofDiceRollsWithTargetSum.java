package DSAPractice.DP;
public class NumberofDiceRollsWithTargetSum {
    public static void main(String[] args) {
        int n = 2, k = 6, target = 7;
        System.out.println(new NumberofDiceRollsWithTargetSum().numRollsToTarget(n,k,target));
    }
    public int numRollsToTarget(int dice, int face, int target) {
        int mod = (int) (1e9+7);
        int dp[][] = new int[dice+1][target+1];
        dp[0][0] = 1;
        for(int i = 1; i <= dice; i++) {
            for(int j = 1; j <= target ; j++) {
                for(int k = 1; k <= face; k++) {
                    if(k <= j) {
                        dp[i][j] = (dp[i][j]+(dp[i-1][j-k])%mod)%mod;
                    }
                }
            }
        }
        return dp[dice][target];
    }
}


