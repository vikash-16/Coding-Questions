package DSAPractice.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueNumberofOccurrences {
    public static void main(String[] args) {
        int [] arr = {1,2,2,1,1,3};
        System.out.println(new UniqueNumberofOccurrences().uniqueOccurrences(arr));
    }
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            freq.put(arr[i],freq.getOrDefault(arr[i],0)+1);
        }
        Set<Integer> collect = freq.values().stream().collect(Collectors.toSet());
        return freq.size() == collect.size();
    }
}
