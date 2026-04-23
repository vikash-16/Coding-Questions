package LeetCode75.Arrays_String;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumSubSequenceScore {
    static void main() {
        int []nums1 = {2,1,14,12}, nums2 = {11,7,13,6};
        int k = 3;
        long l = new MaximumSubSequenceScore().maxScore(nums1, nums2, k);
        System.out.println(l);
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] ess = new int[n][2];
        for (int i = 0; i < n; ++i)
            ess[i] = new int[] {nums1[i], nums2[i]};
        Arrays.sort(ess, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = 0, sumS = 0;
        for (int[] es : ess) {
            pq.add(es[0]);
            sumS = (sumS + es[0]);
            if (pq.size() > k) sumS -= pq.poll();
            if (pq.size() == k) res = Math.max(res, (sumS * es[1]));
        }
        return res;
    }
}
