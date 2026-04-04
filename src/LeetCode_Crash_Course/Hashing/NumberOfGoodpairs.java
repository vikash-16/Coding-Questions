package LeetCode_Crash_Course.Hashing;

import java.util.HashMap;
import java.util.Optional;

public class NumberOfGoodpairs {
    public static void main(String[] args) {
        int [] nums = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(nums));
    }
    public static int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer>counts = new HashMap<>();
        int totalPairs = 0;
        for(int x : nums) {
            counts.put(x,counts.getOrDefault(x,0)+1);
        }
        for(Integer x : counts.keySet()) {
            int freCount = counts.get(x);
            if(freCount >= 2) {
                totalPairs+= (freCount*(freCount-1))/2;
            }
        }
        return totalPairs;
    }
}
