package DSAPractice.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int []nums = {4,8,10,240};
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(nums));
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n];
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        int maxLen = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i]%nums[j] == 0) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    if(maxLen < dp[i]) {
                        maxLen = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }
        List<Integer>result = new ArrayList<>();
        int val = nums[maxIndex];
        for(int i = maxIndex; i >= 0; i--) {
            if(val % nums[i] == 0 && dp[i] == maxLen) {
                result.add(nums[i]);
                val = nums[i];
                maxLen--;
            }
        }
        System.out.println(maxLen+" "+maxIndex);
        return result;
    }
}
