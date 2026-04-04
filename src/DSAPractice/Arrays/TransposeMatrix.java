package DSAPractice.Arrays;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] transpose = new TransposeMatrix().transpose(matrix);
        for(int [] row : transpose) {
            System.out.println(Arrays.toString(row));
        }
    }
    public int[][] transpose(int[][] matrix) {
        int [][] transpose = new int[matrix.length][matrix[0].length];
        for(int i  = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }
}
