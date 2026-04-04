package DSAPractice.DP;

public class MinimumTimetoMakeRopeColorful {
    public static void main(String[] args) {
        String colors = "abaac";
        int []neededTime = {1,2,3,4,5};
        System.out.println(new MinimumTimetoMakeRopeColorful().minCost(colors,neededTime));
    }
    public int minCost(String s, int[] cost) {
        int n = s.length();
        int result = 0;
        for (int i=1; i<n; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                result = result + Math.min(cost[i], cost[i-1]);
                cost[i] = Math.max(cost[i], cost[i-1]);
            }
        }
        return result;
    }
}
