package DSAPractice.DP;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(new PalindromicSubstrings().countSubstrings(s));
    }
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        char[] arr = s.toCharArray();
        int [][]dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
            count++;
        }
        for(int i = 0; i < n-1; i++) {
            if(arr[i] == arr[i+1]) {
                dp[i][i+1] = 1;
                count++;
            }
        }
        for(int len = 3; len <= n; len++) {
            for(int i = 0; i < n-len+1; i++) {
                int j = i+len-1;
                if(dp[i+1][j-1] == 1 && arr[i] == arr[j]) {
                    dp[i][j] = 1;
                    count++;
                }
            }
        }
        return count;
    }
}
