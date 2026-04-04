package DSAPractice.DP;

import java.util.Arrays;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int  [][]matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(new MinimumFallingPathSum().minFallingPathSum(matrix));
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int [][] dp = new int[m][n];
        for(int [] temp: dp) {
            Arrays.fill(temp,Integer.MAX_VALUE);
        }
        int minPathSum = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                minPathSum = Math.min(minPathSum, dfs(matrix, dp, 0, j));
            }
        return minPathSum;
    }

    private int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if(i == matrix.length-1) {
            return matrix[i][j];
        }
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int pathSum = Integer.MAX_VALUE;
        if(j-1 >= 0)
            pathSum = Math.min(pathSum,dfs(matrix, dp, i + 1, j - 1)+matrix[i][j]);
        if(j+1 < matrix.length) {
            pathSum = Math.min(pathSum, dfs(matrix, dp, i + 1, j + 1) + matrix[i][j]);
        }
        pathSum = Math.min(pathSum,dfs(matrix, dp, i + 1, j)+matrix[i][j]);

        dp[i][j] = pathSum;
        return dp[i][j];
    }
}
