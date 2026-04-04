package DSAPractice.Arrays;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int [][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(diagonalSum(mat));
    }
    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum+=mat[i][i];
            sum+=mat[n-i-1][i];
        }
        return n%2== 0 ? sum: sum-mat[n/2][n/2];
    }


}
