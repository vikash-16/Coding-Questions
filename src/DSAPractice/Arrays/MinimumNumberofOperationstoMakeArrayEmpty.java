package DSAPractice.Arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberofOperationstoMakeArrayEmpty {
    public static void main(String[] args) {
        int [] nums = {2,3,3,2,2,4,2,3,4};
        System.out.println(new MinimumNumberofOperationstoMakeArrayEmpty().minOperations(nums));
    }
    public int minOperations(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int n : nums) {
            freq.put(n,freq.getOrDefault(n,0)+1);
        }
        int count = 0;
        for(int num : freq.values()) {
            if(num == 1) return -1;
            count+=Math.ceil((double) num/3);
        }
        return count;
    }
}
