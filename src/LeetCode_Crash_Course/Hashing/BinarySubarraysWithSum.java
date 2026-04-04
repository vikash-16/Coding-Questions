package LeetCode_Crash_Course.Hashing;

import java.util.HashMap;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int [] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums,goal));
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer>coount = new HashMap<>();
        coount.put(0,1);
        int currSum = 0;
        int ans = 0;
        for(var x : nums) {
            currSum+=x;
            ans+=coount.getOrDefault(currSum-goal,0);
            coount.put(currSum,coount.getOrDefault(currSum,0)+1);
        }
        return ans;
    }
}
