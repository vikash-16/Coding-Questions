package LeetCode_Crash_Course.Hashing;

import java.util.HashMap;

public class FindLuckyNumberInAnArray {
    public static void main(String[] args) {
        int [] arr = {1,2,2,3,3,3};
        System.out.println(findLucky(arr));
    }
    public static int findLucky(int[] arr) {
        int largestNumber = -1;
        HashMap<Integer,Integer>counts = new HashMap<>();
        for(Integer x : arr) {
            counts.put(x,counts.getOrDefault(x,0)+1);
        }
        for(Integer i : counts.keySet()) {
            if(counts.get(i) == i) {
                largestNumber = Math.max(largestNumber,i);
            }
        }
        return largestNumber;
    }
}
