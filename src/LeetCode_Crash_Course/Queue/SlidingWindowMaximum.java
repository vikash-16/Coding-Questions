package LeetCode_Crash_Course.Queue;

import java.util.ArrayDeque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = new SlidingWindowMaximum().maxSlidingWindow(nums, k);
        for(int e : ints) System.out.println(e);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer>queue = new ArrayDeque<>();
        int [] result = new int[nums.length-k+1];
        for(int i = 0; i < nums.length; i++) {
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if(queue.getFirst()+k == i) {
                queue.removeFirst();
            }
            if(i >= k-1) {
                result[i-k+1] = nums[queue.getFirst()];
            }
        }
        return result;
    }
}
