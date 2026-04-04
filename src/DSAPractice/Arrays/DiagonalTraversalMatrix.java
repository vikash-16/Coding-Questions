package DSAPractice.Arrays;

import java.util.Arrays;

public class DiagonalTraversalMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] diagonalOrder = findDiagonalOrder(mat);
        for(int a: diagonalOrder) {
            System.out.println(a);
        }

    }
    public static int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int totalCount = row*col;
        int r = 0,c = 0;
        int [] result = new int[totalCount];
        for(int i = 0; i < totalCount; i++) {
            result[i] = mat[r][c];
            if((r+c)%2 == 0) {
                if(c == col-1) {
                    r++;
                }else if(r == 0) {
                    c++;
                }else {
                    r--;
                    c++;
                }
            }else {
                if(r == row-1) {
                    c++;
                }else if(c == 0) {
                    r++;
                }else {
                    r++;
                    c--;
                }
            }
        }
        return result;
    }
}
