package LeetCode_Crash_Course.Hashing;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int [] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer>counts = new HashSet<>();
        for(Integer x : nums) {
            if(counts.contains(x)) {
                return true;
            }
            counts.add(x);
        }
        return false;
    }
}
