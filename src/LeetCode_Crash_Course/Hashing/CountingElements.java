package LeetCode_Crash_Course.Hashing;

import java.util.HashSet;

public class CountingElements {
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        System.out.println(countElements(arr));
    }
    public static int countElements(int[] arr) {
        HashSet<Integer>count = new HashSet<>();
        for(int x : arr) {
            count.add(x);
        }
        int countEle = 0;
        for(int x : arr) {
            if(count.contains(x+1)) {
                countEle++;
            }
        }
        return countEle;
    }
}
