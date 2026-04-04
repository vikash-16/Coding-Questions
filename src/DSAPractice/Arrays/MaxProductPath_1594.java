package DSAPractice.Arrays;

public class MaxProductPath_1594 {
    public static void main(String[] args) {
        int [][] grid = {{1,3},{0,-4}};
        System.out.println(maxProductPath(grid));
    }
    static long maxProduct = -1;
    static int mod = 1000000007;
    public static int maxProductPath(int[][] grid) {
        dfs(0,0,grid[0][0],grid);
        return (int)(maxProduct%mod);
    }

    private static void dfs(int i, int j, long product, int[][] grid) {
        if( i == grid.length - 1 && j == grid[0].length - 1) {
            maxProduct = Math.max(maxProduct, product);
            return;
        }
        if(grid[i][j] == 0) {
            maxProduct = Math.max(maxProduct,0);
            return;
        }
        if(j+1 < grid[i].length) dfs(i,j+1,product*grid[i][j+1],grid);
        if(i+1 < grid.length)dfs(i+1,j,product*grid[i+1][j],grid);
    }
}
