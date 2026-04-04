package LeetCode_Crash_Course.Hashing;

import java.util.HashSet;

public class MissingNumber {
    public static void main(String[] args) {
        int [] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        /*int n  = nums.length;
        int total=  (n*(n+1))/2;
        int eleSum = 0;
        for(int x: nums) {
            eleSum+=x;
        }
        return total-eleSum;*/
        HashSet<Integer>count = new HashSet<>();
        for(int x : nums) {
            count.add(x);
        }
        for(int i = 0; i <=nums.length ; i++) {
            if(!count.contains(i+1)) {
                return i+1;
            }
        }
        return -1;
    }
}
