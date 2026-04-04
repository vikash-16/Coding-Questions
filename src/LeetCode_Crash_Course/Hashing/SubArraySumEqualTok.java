package LeetCode_Crash_Course.Hashing;

import java.util.HashMap;

public class SubArraySumEqualTok {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int k = 2;
        System.out.println(subarraySum(nums,k));

    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>count = new HashMap<>();
        int ans = 0, currSum = 0;
        count.put(0,1);
        for(int i = 0; i < nums.length; i++) {
            currSum+=nums[i];
            ans+=count.getOrDefault(currSum-k,0);
            count.put(currSum,count.getOrDefault(currSum,0)+1);
        }
        return ans;
    }
}
