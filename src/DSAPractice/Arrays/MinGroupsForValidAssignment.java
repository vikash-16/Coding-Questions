package DSAPractice.Arrays;

import java.util.*;

public class MinGroupsForValidAssignment {
    public static void main(String[] args) {
        int [] nums = {3,2,3,2,3};
        System.out.println(new MinGroupsForValidAssignment().minGroupsForValidAssignment(nums));
    }
    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer,Integer>freq = new HashMap<>();
        for(int num : nums) {
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        int minGroupSize = freq.values().stream().mapToInt(i -> i).min().orElse(0);
        for(int size = minGroupSize; size >= 1; size--) {
            int groups = makeGroupHelper(size, freq);
            if(groups > 0) {
                return groups;
            }
        }
        return 0;
    }

    private int makeGroupHelper(int size, Map<Integer, Integer> freq
    ) {
        int totalGroups = 0;
        int next = size+1;
        for(Integer val : freq.values()) {
            int noOfGroups = val / next;
            int remaining = val % next;
            if(remaining == 0) {
                totalGroups+=noOfGroups;
            }else if(noOfGroups >= size-remaining) {
                totalGroups+= noOfGroups + 1;
            }
        }
        return totalGroups;
    }
}
