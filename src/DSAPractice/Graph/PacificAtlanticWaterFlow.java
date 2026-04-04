package DSAPractice.Graph;

import java.util.*;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int [][]heights = {{5,4,2,1,5},{4,2,2,1,5},{1,2,2,3,2},{2,2,2,3,5}};
        System.out.println(new PacificAtlanticWaterFlow().pacificAtlantic(heights));
    }
    int [] dir = {0,1,0,-1,0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int [][] pacific = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(pacific[i],0);
        }
        Queue<int []> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        pacific[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int i = 1; i < dir.length; i++) {
                int x = curr[0] + dir[i - 1],y = curr[1]+dir[i];
                if(x >= 0 && x < m && y >= 0 && y < n) {
                    if(pacific[x][y] == 1) continue;
                    if(x == 0 || y == 0 || heights[x][y] >= heights[curr[0]][curr[1]]) {
                        queue.add(new int[]{x,y});
                        pacific[x][y] = 1;
                    }
                }
            }
        }
        queue.add(new int[]{m-1,n-1});
        if(pacific[m-1][n-1] == 1) {
            pacific[m-1][n-1] = 3;
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int i = 1; i < dir.length; i++) {
                int x = curr[0]+dir[i-1], y = curr[1]+dir[i];
                if(x >= 0 && x < m && y >= 0 && y < n) {
                    if(pacific[x][y] == 2 || pacific[x][y] == 3) continue;
                    if(x == m-1 || y == n-1 || heights[x][y] >= heights[curr[0]][curr[1]]) {
                        queue.add(new int[]{x,y});
                        if(pacific[x][y] == 1) {
                            pacific[x][y] = 3;
                        }else {
                            pacific[x][y] = 2;
                        }
                    }
                }
            }
        }
        List<List<Integer>>result = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] == 3) {
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }
}
