package DSAPractice.DP;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(new DecodeWays().numDecodings(s));
    }
    public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int[n+1];
        char[] array = s.toCharArray();
        dp[0] = 1;
        dp[1] = 1;
        if(array[0] == '0') {
            return 0;
        }
        for(int i = 2; i <= n; i++) {
            if(array[i-1] > '0') {
                dp[i] = dp[i-1];
            }
            if(array[i-2] == '1' || array[i-2] == '2' && array[i-1] < '7') {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
