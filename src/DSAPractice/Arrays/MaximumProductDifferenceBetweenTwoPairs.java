package DSAPractice.Arrays;

import JavaExample.Main;

import java.util.Arrays;

public class MaximumProductDifferenceBetweenTwoPairs {
    public static void main(String[] args) {
        int [] nums = {4,2,5,9,7,4,8};
        System.out.println(new MaximumProductDifferenceBetweenTwoPairs().maxProductDifference(nums));
    }
    public int maxProductDifference(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n-1]*nums[n-2]-nums[0]*nums[1];
    }
}
