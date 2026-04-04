package DSAPractice.Arrays;

import java.util.Arrays;

public class SortStudentsByKthOrder {
    public static void main(String[] args) {
        int [][] score = {{10,6,9,1},{7,5,11,2},{4,8,3,15}};
        int k = 2;
        sortTheStudents(score,k);
        for(int i = 0; i < score.length; i++) {
            for(int j = 0; j < score[0].length; j++) {
                System.out.print(score[i][j]);
            }
            System.out.println();
        }
    }
    public static int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score,(a,b)->b[k]-a[k]);
        return score;
    }
}
