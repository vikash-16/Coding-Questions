package LeetCode75.Arrays_String;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
    static void main() {
        int [][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        RottingOranges rottingOranges = new RottingOranges();
        System.out.println(rottingOranges.orangesRotting(grid));

    }
    public int orangesRotting(int[][] grid) {
        Queue<int []>queue = new ArrayDeque<>();
        int totalOrange = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1 || grid[i][j] == 2) {
                    totalOrange++;
                }
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        if(totalOrange == 0) return 0;
        int rottenOrange = 0;
        int time = 0;
        int [][]dir = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            rottenOrange+=size;
            if(totalOrange == rottenOrange) {
                return time;
            }
            time++;
            for(int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for(int d = 0; d < dir.length; d++) {
                    int x = point[0]+dir[d][0];
                    int y = point[1]+dir[d][1];
                    if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.add(new int[]{x,y});
                    }

                }
            }
        }
        return -1;
    }
}
