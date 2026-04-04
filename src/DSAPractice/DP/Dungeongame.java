package DSAPractice.DP;

import java.util.Arrays;

public class Dungeongame {
    public static void main(String[] args) {
        Dungeongame dungeongame = new Dungeongame();
        int [][]dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(dungeongame.calculateMinimumHP(dungeon));
    }
    /**
     * top to Bottom Approach using recursion
     *
     *
     * int [][]dp;
    public int calculateMinimumHP(int[][] dungeon) {
        dp = new int[dungeon.length][dungeon[0].length];
        for (int i = 0; i < dungeon.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfsHelper(dungeon,0,0);
    }

    public int dfsHelper(int[][] dungeon, int i, int j) {
        if(i >=dungeon.length || j >=dungeon[0].length) return Integer.MAX_VALUE;
        if(i == dungeon.length-1 && j == dungeon[0].length-1) return Math.max(1,1- dungeon[i][j]);
        if(dp[i][j] != -1) return dp[i][j];
        int res = Math.min(dfsHelper(dungeon, i + 1, j), dfsHelper(dungeon, i, j + 1)) - dungeon[i][j];
        res = Math.max(1,res);
        return dp[i][j]= res;
    }*/
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int [][]dp = new int[m+1][n+1];
        for(int i = 0; i <= dungeon.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m-1][n] = 1;dp[m][n-1] = 1;
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                int res = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] =  Math.max(1,res);
            }
        }
        return dp[0][0];
    }
}
