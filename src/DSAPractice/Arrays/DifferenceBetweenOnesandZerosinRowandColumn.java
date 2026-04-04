package DSAPractice.Arrays;

import java.util.Arrays;

public class DifferenceBetweenOnesandZerosinRowandColumn {
    public static void main(String[] args) {
        int [][]grid =  {{1,1,1},{1,1,1}};
        int[][] ints = new DifferenceBetweenOnesandZerosinRowandColumn().onesMinusZeros(grid);
        for(int [] row : ints) {
            System.out.println(Arrays.toString(row));
        }
    }
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int []rowOnes = new int[grid.length], colOnes = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int  j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    rowOnes[i]++;
                    colOnes[j]++;
                }
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                grid[i][j] = rowOnes[i]+colOnes[j]-(m-rowOnes[i])-(n-colOnes[j]);
            }
        }
        return grid;
    }
}
