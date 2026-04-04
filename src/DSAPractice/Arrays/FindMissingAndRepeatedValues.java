package DSAPractice.Arrays;

import java.util.Arrays;

public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        int [][]grid = {{1,3},{2,2}};
        int[] missingAndRepeatedValues = new FindMissingAndRepeatedValues().findMissingAndRepeatedValues(grid);
        Arrays.stream(missingAndRepeatedValues).forEach(System.out::println);
    }
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int length = grid.length* grid.length;
        int [] frequency = new int[length+1];
        int index = 0;
        for(int [] row: grid) {
            for(int num: row) {
                frequency[num]++;
            }
        }
        int notRepeated = 0, repeated = 0;
        for(int i = 1; i < length+1; i++) {
            if(frequency[i] == 2) {
                repeated = i;
            }
            if(frequency[i] == 0) {
                notRepeated = i;
            }
        }
        return new int[]{repeated, notRepeated};
    }
}
