package LeetCode_Crash_Course.Hashing;

import java.util.HashMap;

public class CountNumberOfNiceSubArrays {
    public static void main(String[] args) {
        int [] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums,k));
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer>counts = new HashMap<>();
        counts.put(0,1);
        int ans = 0,oddNum = 0;
        for(int x : nums) {
            oddNum+=x%2;
            ans+=counts.getOrDefault(oddNum-k,0);
            counts.put(oddNum,counts.getOrDefault(oddNum,0)+1);
        }
        return ans;
    }
}
