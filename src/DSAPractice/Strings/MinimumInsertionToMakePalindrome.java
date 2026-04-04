package DSAPractice.Strings;

public class MinimumInsertionToMakePalindrome {
    public static void main(String[] args) {
        String s = "aad";
        System.out.println(countMin(s));
    }
    static int countMin(String str) {
        int n = str.length();
        StringBuilder str2 = new StringBuilder(str);
        str2.reverse();
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }else if(str.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return n-dp[n][n];
    }
}
