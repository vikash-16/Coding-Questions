package LeetCode75.Arrays_String;

import java.util.PriorityQueue;
import java.util.Queue;

public class TotalCostToHirekWorkers {
    static void main() {
        int []costs = {1,2,4,1}; int k = 3, candidates = 3;
        System.out.println(new TotalCostToHirekWorkers().totalCost(costs,k,candidates));
    }
    public long totalCost(int[] costs, int k, int candidates) {
        Queue<int []>leftCandidates = new PriorityQueue<>(candidates,(a,b)->a[0]-b[0]);
        Queue<int []>rightCandidates = new PriorityQueue<>(candidates,(a,b)->a[0]-b[0]);
        int i = 0,j = costs.length-1;
        long totalCost = 0;
        while (k > 0) {
            while (leftCandidates.size() < candidates && i <= j) {
                leftCandidates.add(new int[]{costs[i],i});
                i++;
            }
            while (rightCandidates.size() < candidates && i <= j) {
                rightCandidates.add(new int[]{costs[j],j});
                j--;
            }

            int[] leftLowcost = leftCandidates.size()> 0 ? leftCandidates.peek(): new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
            int []rightLowCost = rightCandidates.size()> 0? rightCandidates.peek(): new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
            if(leftLowcost[0] <= rightLowCost[0]) {
                totalCost+=leftLowcost[0];
                leftCandidates.poll();
            }else {
                totalCost+=rightLowCost[0];
                rightCandidates.poll();
            }
            k--;
        }
        return totalCost;
    }
}
