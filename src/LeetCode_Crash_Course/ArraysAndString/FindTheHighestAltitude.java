package LeetCode_Crash_Course.ArraysAndString;

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        int [] gain = {-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));

    }
    public static int largestAltitude(int[] gain) {
        int currAltitude = 0;
        int highestAltitude = 0;
        for(int x : gain) {
            currAltitude+=x;
            highestAltitude = Math.max(highestAltitude,currAltitude);
        }
        return highestAltitude;
    }
}
