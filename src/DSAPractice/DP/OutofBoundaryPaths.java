package DSAPractice.DP;

import java.util.Arrays;

public class OutofBoundaryPaths {
    public static void main(String[] args) {
        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        System.out.println(new OutofBoundaryPaths().findPaths(m,n,maxMove,startRow,startColumn));
    }
    int [][][]dp;
    int [] dir = {0,1,0,-1,0};
    int x = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove+1];
        for(int [][] a: dp) {
            for(int [] b : a) {
                Arrays.fill(b,-1);
            }
        }
        int i = dfsHelper(m, n, maxMove, startRow, startColumn);
        return i;
    }

    private int dfsHelper(int m, int n, int maxMove, int startRow, int startColumn) {
        if(startRow < 0 || startColumn < 0 || startRow ==m || startColumn == n) {
            return 1;
        }
        if(maxMove <= 0) {
            return 0;
        }
        if(dp[startRow][startColumn][maxMove] >= 0) {
            return dp[startRow][startColumn][maxMove];
        }
        int sum = 0;
        for(int i = 1; i < dir.length; i++) {
             sum = (sum)%x +(dfsHelper(m, n, maxMove - 1, startRow + dir[i - 1], startColumn + dir[i])%x);
        }
        return dp[startRow][startColumn][maxMove] = sum;
    }
}
