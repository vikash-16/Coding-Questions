package DSAPractice;

import java.util.Arrays;

public class EqualSumPartitionGrid {
    public static void main(String[] args) {
        EqualSumPartitionGrid equalSumPartitionGrid = new EqualSumPartitionGrid();
        boolean b = equalSumPartitionGrid.canPartitionGrid(new int[][]{{1, 4}, {2, 3}});
        System.out.println(b);
    }
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if(m == 1 && n == 1) {
            if(grid[0][0] == grid[0][1]) {
                return true;
            }else {
                return false;
            }
        }
        int []rowSum = new int[n], colSum = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                rowSum[i]+=grid[i][j];
                colSum[j]+=grid[i][j];
            }
        }
        int [] preRowSum = new int[m];
        preRowSum[0] = rowSum[0];
        int [] preColSum = new int[n];
        preColSum[0] = colSum[0];
        for(int i = 1; i < m; i++) {
            preRowSum[i] = preRowSum[i-1]+rowSum[i];
        }
        for(int i = 1; i < n; i++) {
            preColSum[i] = preColSum[i-1]+colSum[i];
        }
        for(int i = 0; i < m; i++) {
            if(preRowSum[i] == (preRowSum[m-1]-preRowSum[i])) return true;
        }
        for(int i = 0; i < n; i++) {
            if(preColSum[i] == (preColSum[m-1]-preColSum[i])) return true;
        }
        Arrays.stream(preRowSum).forEach(System.out::println);
        Arrays.stream(colSum).forEach(System.out::println);
        return false;
    }

}
