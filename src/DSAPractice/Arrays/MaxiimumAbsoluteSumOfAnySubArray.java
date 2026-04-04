package DSAPractice.Arrays;

import javax.naming.ldap.HasControls;
import java.util.Collections;
import java.util.HashMap;

public class MaxiimumAbsoluteSumOfAnySubArray {
    public static void main(String[] args) {
        int maxAbsoluteSum = new MaxiimumAbsoluteSumOfAnySubArray().maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2});
        System.out.println(maxAbsoluteSum);
    }
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currentSum1 = 0, currentSum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum1 = Math.max(nums[i], currentSum1+nums[i]);
            maxSum = Math.max(currentSum1,maxSum);
            currentSum2 = Math.min(currentSum2+nums[i],nums[i]);
            minSum = Math.min(minSum, currentSum2);
            new HashMap<>().entrySet();
        }
        return Math.max(Math.abs(maxSum), Math.abs(minSum ));
    }
}
