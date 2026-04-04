package DSAPractice.Arrays;

import java.util.Arrays;
import java.util.Map;

public class FindChampionI {
    public static void main(String[] args) {
       int [][] num =  {{0,1},{0,0}};
        System.out.println(new FindChampionI().findChampion(num));
    }
    public int findChampion(int[][] grid) {
        int [] result = new int[grid.length];
        Arrays.fill(result,0);
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1 && i != j) {
                    result[i]++;
                }else {
                    result[j]++;
                }
            }
        }
        int current = 0,winnerIndex= 0;
        for(int i = 0; i < result.length; i++) {
            if(current < result[i]) {
                current = result[i];
                winnerIndex = i;
            }
        }
        return winnerIndex;
    }
}
