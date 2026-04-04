package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpirallyTraversingMatrix {
    public static void main(String[] args) {
        int matrix[][] = {{6,6,2,28,2}, {12,26,3,28,7}, {22,25,3,4,23}};
        ArrayList<Integer> resultList = spirallyTraverse(matrix, matrix.length, matrix[0].length);
        for(int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int top = 0, bottom = r-1;
        int left = 0, right = c-1;
        int index = 0, totalCount = r*c;
        ArrayList<Integer>resultList = new ArrayList<>();
        while(index < totalCount) {
            for(int i = left; i <= right; i++) {
                if(index < totalCount) {
                    resultList.add(matrix[top][i]);
                    index++;
                }
            }
            top++;
            for(int i = top; i <= bottom; i++) {
                if(index < totalCount) {
                    resultList.add(matrix[i][right]);
                    index++;
                }
            }
            right--;
            for(int i = right; i >= left; i--) {
                if(index < totalCount) {
                    resultList.add(matrix[bottom][i]);
                    index++;
                }
            }
            bottom--;
            for(int i = bottom; i >= top; i--) {
                if(index < totalCount) {
                    resultList.add(matrix[i][left]);
                    index++;
                }
            }
            left++;
        }
        return resultList;
    }
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        int top = 0, bottom = r-1;
        int left = 0, right = c-1;
        int index = 0, totalCount = r*c;
        ArrayList<Integer>resultList = new ArrayList<>();
        while(index < totalCount) {
            for(int i = left; i <= right; i++) {
                if(index < totalCount) {
                    resultList.add(matrix[top][i]);
                    index++;
                }
            }
            top++;
            for(int i = top; i <= bottom; i++) {
                if(index < totalCount) {
                    resultList.add(matrix[i][right]);
                    index++;
                }
            }
            right--;
            for(int i = right; i >= left; i--) {
                if(index < totalCount) {
                    resultList.add(matrix[bottom][i]);
                    index++;
                }
            }
            bottom--;
            for(int i = bottom; i >= top; i--) {
                if(index < totalCount) {
                    resultList.add(matrix[i][left]);
                    index++;
                }
            }
            left++;
        }
        return resultList;
    }
}
