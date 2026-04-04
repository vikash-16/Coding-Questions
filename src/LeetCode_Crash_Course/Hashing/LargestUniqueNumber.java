package LeetCode_Crash_Course.Hashing;

import java.util.HashMap;

public class LargestUniqueNumber {
    public static void main(String[] args) {
        int [] nums = {5,7,3,9,4,9,8,3,1};
        System.out.println(largestUniqueNumber(nums));

    }
    public static int largestUniqueNumber(int[] nums) {
        HashMap<Integer,Integer>counts = new HashMap<>();
        for(int x : nums) {
            counts.put(x,counts.getOrDefault(x,0)+1);
        }
        int result = -1;
        for(Integer num : counts.keySet()) {
            if(counts.get(num) == 1) {
                result = Math.max(result,num);
            }
        }
        return result;
    }
}
