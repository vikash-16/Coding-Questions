package LeetCode75.Arrays_String;

public class MaxProductPath {
    public static void main(String[] args) {
//        MaxProductPath maxProductPath = new MaxProductPath().maxProductPath(null);
//        System.out.println(maxProductPath);
    }
    public int maxProductPath(int[][] grid) {
        int result[][] = new int[grid.length][grid[0].length];
        int maxProductSum = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) {
                    result[i][j] = grid[i][j];
                }else if (i == 0) {
                    result[i][j] = grid[i][j]*result[i][j-1];
                }else if(j == 0) {
                    result[i][j] = grid[i][j]*result[i-1][j];
                }else {
                    result[i][i] = Math.max(result[i-1][j],result[i][j-1])*grid[i-1][j-1];
                }
                maxProductSum = Math.max(maxProductSum,result[i][j]);
            }
        }
        return maxProductSum < 0 ? -1: maxProductSum;
    }
}
