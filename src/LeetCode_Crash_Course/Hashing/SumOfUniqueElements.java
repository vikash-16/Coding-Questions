package LeetCode_Crash_Course.Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SumOfUniqueElements {
    public static void main(String[] args) {
        int [] nums = {1,2,3,2};
        System.out.println(sumOfUnique(nums));
    }
    public static int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer>count = new HashMap<>();
        int countUniqueEle = 0;
        for(Integer num : nums) {
            count.put(num,count.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer, Integer> entries:count.entrySet()) {
            if(entries.getValue() == 1) {
                countUniqueEle+=entries.getKey();
            }
        }
        return countUniqueEle;
    }
}
