package DSAPractice.Arrays;

import java.util.*;

public class DiagonalTraverseII {
    public static void main(String[] args) {
        List<List<Integer>> nums = List.of(List.of(1,2,3,4,5), List.of(6,7), List.of(7, 8, 9));
        System.out.println(Arrays.toString(new DiagonalTraverseII().solution(nums)));
    }
    //[1,4,2,7,5,3,8,6,9]
    /*public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<int []>queue = new ArrayDeque<>();
        List<Integer>temp = new ArrayList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];
            temp.add(nums.get(row).get(col));
            if(col == 0 && row+1 < nums.size()) {
                queue.add(new int[]{row+1,col});
            }
            if(col+1 < nums.get(row).size()) {
                queue.add(new int[]{row,col+1});
            }
        }
        int [] ans = new int[temp.size()];
        int i = 0;
        for(int num : temp) {
            ans[i++] = num;
        }
        return ans;
    }*/
    public int [] solution(List<List<Integer>> nums) {
        int rowSize = nums.size();
        int start = 0;
        while (start < rowSize) {
            int i = start;
            int j = 0;
            while (i >= 0) {
                System.out.println(nums.get(i).get(j));
                i--;
                j++;
            }
            start++;
        }
        return null;
    }
}
