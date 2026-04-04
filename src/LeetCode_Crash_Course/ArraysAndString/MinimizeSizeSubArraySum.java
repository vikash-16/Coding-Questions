package LeetCode_Crash_Course.ArraysAndString;

public class MinimizeSizeSubArraySum {
    public static void main(String[] args) {
        int target = 7;
        int [] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target,nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int currSum = 0,length = Integer.MAX_VALUE,left = 0;
        for(int right = 0; right < nums.length; right++) {
            currSum+=nums[right];
            while(currSum >= target) {
                length = Math.min(length,right-left+1);
                currSum-=nums[left++];
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}

