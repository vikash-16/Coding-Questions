package LeetCode_Crash_Course.Hashing;

import java.util.HashMap;

public class MinimumConsecutiveCardstoPickUp {
    public static void main(String[] args) {
        int [] nums = {1,2,6,2,1};
        System.out.println(minimumCardPickup(nums));
    }
    public static int minimumCardPickup(int[] cards) {
        int ans = Integer.MAX_VALUE;
        HashMap<Integer,Integer>counts = new HashMap<>();
        for(int i = 0; i < cards.length; i++) {
            if(counts.containsKey(cards[i])) {
               ans = Math.min(ans, i-counts.get(cards[i]) +1); 
            }
            counts.put(cards[i], i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
