package DSAPractice.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DivideArrayIntoArraysWithMaxDifference {
    public static void main(String[] args) {
        int []nums = {15,13,12,13,12,14,12,2,3,13,12,14,14,13,5,12,12,2,13,2,2};
        int k = 2;
        int[][] ints = new DivideArrayIntoArraysWithMaxDifference().divideArray(nums, k);
        for(int [] row : ints) {
            System.out.println(Arrays.toString(row));
        }
    }
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int [][] result = new int[n/3][3];
        int row = 0;
        for(int i = 0; i < n; i+=3) {
            if(i+2 < n && Math.abs(nums[i+2]-nums[i]) <= k) {
                result[row++] = new int[]{nums[i],nums[i+1],nums[i+2]};
            }else {
                return new int[][]{};
            }
        }
        return result;
    }

}
