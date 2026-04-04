package DSAPractice.DP;

public class MostPoints {
    public static void main(String[] args) {
        int [][] questions = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        long l = new MostPoints().mostPoints(questions);
        System.out.println(l);
    }
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long []dp = new long[questions.length+1];
        for(int i = n-1; i >= 0; i--) {
            int points = questions[i][0];
            int jumps = questions[i][1];
            dp[i] = Math.max(points+dp[Math.min(i+jumps+1,n)], dp[i+1]);
        }
        return dp[0];
    }
}
