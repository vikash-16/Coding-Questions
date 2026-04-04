package DSAPractice.Arrays;

import java.util.*;

public class MaximumSumWithatMostKElements {
    public static void main(String[] args) {
        int [][]grid = {{1,2},{3,4}};
        int [] limits = {1,2};
        int k = 2;
        long l = new MaximumSumWithatMostKElements().maxSum(grid, limits, k);
        System.out.println(l);
    }
    public long maxSum(int[][] grid, int[] limits, int k) {
        long maxSum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
        for(int [] row: grid) {
            Arrays.sort(row);
        }
        for(int i=0; i<limits.length; i++) {
            int rowLimit = limits[i];
            int length = grid[i].length-1;
            while (rowLimit > 0) {
                pq.add(grid[i][length--]);
                rowLimit--;
            }
        }
        while (!pq.isEmpty() && k > 0) {
            maxSum += pq.poll();
            k--;
        }
        return maxSum;
    }
}
