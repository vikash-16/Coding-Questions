package LeetCode_Crash_Course.Queue;

import java.util.ArrayDeque;

public class LongestSubArrayWithAbsoluteDiff {
    public static void main(String[] args) {
        int [] nums = {8,2,4,7};
        System.out.println(new LongestSubArrayWithAbsoluteDiff().longestSubarray(nums,4));
    }
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer>ascQueue = new ArrayDeque<>();
        ArrayDeque<Integer>descQueue = new ArrayDeque<>();
        int left =0,right = 0;
        int lenOfSubArray = 0;
        for(right = 0; right < nums.length; right++) {
            while (!ascQueue.isEmpty() && ascQueue.getLast() > nums[right]) {
                ascQueue.removeLast();
            }
            while (!descQueue.isEmpty() && descQueue.getLast() < nums[right]) {
                descQueue.removeLast();
            }
            ascQueue.addLast(nums[right]);
            descQueue.addLast(nums[right]);
            if(descQueue.getFirst()-ascQueue.getFirst() > limit) {
                if(descQueue.getFirst() == nums[left]) {
                    descQueue.removeFirst();
                }
                if(ascQueue.getFirst() == nums[left]) {
                    ascQueue.removeFirst();
                }
                left++;
            }
            lenOfSubArray = Math.max(lenOfSubArray,right-left+1);
        }
        return lenOfSubArray;
    }
}
