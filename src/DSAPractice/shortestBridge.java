package DSAPractice;

public class shortestBridge {
    public static void main(String[] args) {
        int [][] grid = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        System.out.println(new shortestBridge().shortestBridge(grid));
    }
    public  int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid.length;
        int minCount = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    minCount = Math.min(minCount,dfs(i,j,m,n,grid));
                }
            }
        }
        return 0;
    }
    public  int dfs(int i, int j, int m, int n, int[][] grid) {
        if(i < 0 || j < 0 || i >= m || i >= n || grid[i][j] == 0) {
            return 0;
        }
        return 0;
    }
}
