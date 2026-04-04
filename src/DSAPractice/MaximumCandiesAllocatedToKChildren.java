package DSAPractice;

public class MaximumCandiesAllocatedToKChildren {
    public static void main(String[] args) {
        int [] candies = {5,8,6};
        System.out.println(maximumCandies(candies,3));
    }
    public static int maximumCandies(int[] candies, long k) {
        int totalCandies = 0;
        int minimumCandy = Integer.MAX_VALUE;
        for(int i : candies) {
            minimumCandy = Math.min(minimumCandy,i);
            totalCandies+=i;
        }
        if(totalCandies < k) {
            return 0;
        }
        return minimumCandy;
    }
}
