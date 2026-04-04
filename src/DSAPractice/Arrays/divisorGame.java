package DSAPractice.Arrays;
public class divisorGame {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new divisorGame().divisorGame(n));
    }
    public boolean divisorGame(int n) {
        boolean dp[] = new boolean[n+1];
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j*j <= i; j++) {
                if(i % j == 0 && !dp[i-j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}

