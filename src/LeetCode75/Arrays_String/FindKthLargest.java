package LeetCode75.Arrays_String;


import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargest {
    static void main() {
        int []nums = {3,2,1,5,6,4};
        int k = 2;
        int kthLargest = new FindKthLargest().findKthLargest(nums, k);
        System.out.println(kthLargest);

    }
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer>queue = new PriorityQueue<>((a,b)->b-a);
        for(int n: nums) {
            queue.add(n);
        }
        while (k > 1) {
            queue.poll();
            k--;
        }
        return queue.peek();
    }
}
