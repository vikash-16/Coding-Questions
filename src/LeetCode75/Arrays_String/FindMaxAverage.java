package LeetCode75.Arrays_String;

public class FindMaxAverage {
    public static void main(String[] args) {
        double maxAverage = new FindMaxAverage().findMaxAverage(new int[]{-1}, 1);
        System.out.println(maxAverage);
    }
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = Double.NEGATIVE_INFINITY;
        double [] prefixSum = new double[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1]+nums[i];
        }
        int i = 0, j = k-1;
        maxAverage = Math.max(maxAverage,(double) (prefixSum[j]/k));
        for(j = k; j < nums.length; j++) {
            maxAverage = Math.max(maxAverage,(prefixSum[j]-prefixSum[i++])/k);
        }
        return maxAverage;
    }
}

