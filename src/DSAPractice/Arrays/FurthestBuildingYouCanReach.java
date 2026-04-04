package DSAPractice.Arrays;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public static void main(String[] args) {
        int []heights = {4,2,7,6,9,14,12};
        int bricks = 5, ladders = 1;
        System.out.println(new FurthestBuildingYouCanReach().furthestBuilding(heights,bricks,ladders));
    }
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);
        for(int i = 1; i < heights.length; i++) {
            if(heights[i] > heights[i-1]) {
            pq.add(heights[i]-heights[i-1]);
            }
            if(pq.size() > ladders) {
                bricks-=pq.poll();
            }
            if(bricks < 0) {
                return i-1;
            }
        }
        return heights.length-1;
    }
}
