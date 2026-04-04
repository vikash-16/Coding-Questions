package DSAPractice.Greedy;

import java.util.Arrays;

public class MaximumNumberofCoinsYouCanGet {
    public static void main(String[] args) {
        int []piles = {9,8,7,6,5,1,2,3,4};
        System.out.println(new MaximumNumberofCoinsYouCanGet().maxCoins(piles));
    }
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i = piles.length-2;
        int maxCoins = 0;
        for(int j = 0 ; j < piles.length/3; j++) {
            maxCoins+=piles[i];
            i-=2;
        }
        return maxCoins;
    }
}
