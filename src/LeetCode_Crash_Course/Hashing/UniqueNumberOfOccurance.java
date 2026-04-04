package LeetCode_Crash_Course.Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurance {
    public static void main(String[] args) {
        int [] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueOccurrences(arr));
    }
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer>countFreq = new HashMap<>();
        HashSet<Integer>uniqueFreq = new HashSet<>();
        for(Integer x : arr) {
            countFreq.put(x,countFreq.getOrDefault(x,0)+1);
        }
        uniqueFreq.addAll(countFreq.values());
        return uniqueFreq.size()==countFreq.size();
    }
}
