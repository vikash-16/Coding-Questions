package DSAPractice.Arrays;

public class GarbageCollector {
    public static void main(String[] args) {
        String[] garbage = {"MMM","PGM","GP"};
        int[] travel = {3,10};
        System.out.println(garbageCollection(garbage,travel));
    }
    public static int garbageCollection(String[] garbage, int[] travel) {
        int totalGarbage = 0;
        int total = 0;

        int [] prefixSum = new int[garbage.length];
        for(int i = 1; i < garbage.length; i++) {
            prefixSum[i] = prefixSum[i-1]+travel[i-1];
        }
        int[] last = new int[128];
        for(int i = 0; i < garbage.length; i++) {
            totalGarbage+=garbage[i].length();
            for(int j = 0; j < garbage[i].length(); j++) {
                last[garbage[i].charAt(j)] = i;
            }
        }
        char[] chars = "PGM".toCharArray();
        for(int i = 0; i < chars.length; i++) {
            totalGarbage+=prefixSum[last[chars[i]]];
        }
        return totalGarbage;
    }
}
