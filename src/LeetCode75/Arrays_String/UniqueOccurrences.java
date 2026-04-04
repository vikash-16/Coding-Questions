package LeetCode75.Arrays_String;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueOccurrences {
    public static void main(String[] args) {
        boolean b = new UniqueOccurrences().uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3});
        System.out.println(b);
    }
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer>freq = new HashMap<>();
        for(int n: arr) {
            freq.put(n,freq.getOrDefault(n,0)+1);
        }
        Set<Integer> collect = freq.values().stream().collect(Collectors.toSet());
        return freq.size() == collect.size();
    }
}
