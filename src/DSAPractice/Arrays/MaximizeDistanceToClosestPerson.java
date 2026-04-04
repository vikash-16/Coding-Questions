package DSAPractice.Arrays;

import java.util.Arrays;

public class MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        int [] nums = {1,0,0,0,1,0,1};
        System.out.println(new MaximizeDistanceToClosestPerson().maxDistToClosest(nums));
    }
    public int maxDistToClosest(int[] seats) {
        int []left = new int[seats.length];
        int [] right = new int[seats.length];
        Arrays.fill(left,seats.length);
        Arrays.fill(right,seats.length);
        int dist = Integer.MIN_VALUE;
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 1) {
                left[i] = 0;
            }else {
                if(i>0) left[i] = left[i-1]+1;
            }
        }
        for(int i = seats.length-1; i >= 0; i--) {
            if(seats[i] == 1) {
                right[i] = 0;
            }else {
                if(i < seats.length-1) right[i] = right[i+1]+1;
            }
        }
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 0) {
                dist = Math.max(dist,Math.min(left[i],right[i]));
            }
        }
        return dist;
    }
}
