package LeetCode75.Arrays_String;

import java.util.Arrays;

public class LargestAltitude {
    public static void main(String[] args) {
        int i = new LargestAltitude().largestAltitude(new int[]{-5, 1, 5, 0, -7});
        System.out.println(i);
    }
    public int largestAltitude(int[] gain) {
        int largestAlt = 0;
        int currAlt = 0;
        for(int i = 0; i < gain.length; i++) {
            currAlt+=gain[i];
            largestAlt = Math.max(largestAlt,currAlt);
        }
        return largestAlt;
    }
}
