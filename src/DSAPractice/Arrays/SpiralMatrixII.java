package DSAPractice.Arrays;

/*Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.



Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]


Constraints:

1 <= n <= 20*/
public class SpiralMatrixII {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(10);
        for(int [] row: ints) {
            for(int ele : row) {
                System.out.print(ele+"\t");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n) {
        int totalEle = n*n;
        int [][] mat = new int [n][n];
        int index = 1;
        int left = 0,right = n-1,top = 0,bottom = n-1;
        while(top <= bottom && left <= right && index <= totalEle) {
            for(int i = left; i <= right; i++) {
                mat[top][i] = index++;
            }
            top++;
            for(int i = top; i<= bottom; i++) {
                mat[i][right] = index++;
            }
            right--;
            for(int i = right; i >= left; i--) {
                mat[bottom][i] = index++;
            }
            bottom--;
            for(int i = bottom; i >= top; i--) {
                mat[i][left] = index++;
            }
            left++;
        }
        return mat;
    }
}

