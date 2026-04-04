package LeetCode75.Arrays_String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EqualPairs {
    public static void main(String[] args) {
        int i = new EqualPairs().equalPairs(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}});
        System.out.println(i);
    }
    public int equalPairs(int[][] grid) {
        int totalPair = 0;
        Map<List<Integer>,Integer> freq = new HashMap<>();
        for(int [] row:grid) {
            List<Integer> collect = Arrays.stream(row).boxed().collect(Collectors.toList());
            freq.put(collect,freq.getOrDefault(collect,0)+1);
        }
        for(int j = 0; j < grid[0].length; j++) {
            int []col = new int[grid[0].length];
            for(int i = 0; i < grid.length; i++) {
                col[i] = grid[i][j];
            }
            List<Integer> collect = Arrays.stream(col).boxed().collect(Collectors.toList());
            if(freq.containsKey(collect)){
                totalPair+=freq.get(collect);
            }
        }
        return totalPair;
    }
}
