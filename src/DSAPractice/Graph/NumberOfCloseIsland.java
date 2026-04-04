package DSAPractice.Graph;

public class NumberOfCloseIsland {
    public static void main(String[] args) {
        int [][]grid = {{1,1,1,1,1,1,1,0},
                        {1,0,0,0,0,1,1,0},
                        {1,0,1,0,1,1,1,0},
                        {1,0,0,0,0,1,0,1},
                        {1,1,1,1,1,1,1,0}};
        System.out.println(new NumberOfCloseIsland().closedIsland(grid));
    }
    public int closedIsland(int[][] grid) {
        int closedIsland = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    closedIsland+=dfs(i,j,m,n,grid);
                }
            }
        }
        return closedIsland;
    }

    public int dfs(int i, int j, int m, int n, int[][] grid) {
        if(i < 0 || j < 0 || i >= m || j >=n ) {
            return 0;
        }
        if(grid[i][j] == 1) {
            return 1;
        }
        grid[i][j] = 1;
        int up = dfs(i - 1, j, m, n, grid);
        int down = dfs(i + 1, j, m, n, grid);
        int left = dfs(i, j - 1, m, n, grid);
        int right = dfs(i, j + 1, m, n, grid);
        if(up  == 1 && down == 1 && left == 1 && right == 1) {
            return 1;
        }
        return 0;
    }
}
