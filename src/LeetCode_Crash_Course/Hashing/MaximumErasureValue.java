package LeetCode_Crash_Course.Hashing;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumErasureValue {
    public static void main(String[] args) {
        int []nums = {4,2,4,5,6};
        System.out.println(maximumUniqueSubarray(nums));
    }
    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> count = new HashSet<>();
        int currSum = 0,maxSum = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            currSum+=nums[right];
            while(count.contains(nums[right])) {
                count.remove(nums[left]);
                currSum-=nums[left++];
            }
            count.add(nums[right]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}
