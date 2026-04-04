package DSAPractice.Arrays;

import java.util.Arrays;

public class FindMaxAverage {
    public static void main(String[] args) {
        double maxAverage = new FindMaxAverage().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3, 4}, 4);
        System.out.println(maxAverage);
    }
    public double findMaxAverage(int[] nums, int k) {
        int [] presum = new int[nums.length+1];
        presum[1] = nums[0];
        for (int i = 2; i < nums.length+1; i++) {
            presum[i] = nums[i-1]+presum[i-1];
        }
        int i = 1, j = k;
        double max  = Double.MIN_VALUE;
        while(j < nums.length) {
            max = Math.max(max,(double) presum[j]-presum[i-1]/k);
            i++;
            j++;
        }
        return max;
    }
}
