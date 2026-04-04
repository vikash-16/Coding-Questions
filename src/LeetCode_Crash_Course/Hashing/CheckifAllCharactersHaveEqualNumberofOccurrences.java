package LeetCode_Crash_Course.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckifAllCharactersHaveEqualNumberofOccurrences {
    public static void main(String[] args) {
        String s = "abacbc";
        System.out.println(areOccurrencesEqual(s));
    }
        public static boolean areOccurrencesEqual(String s) {
            Map<Character, Integer> counts = new HashMap<>();
            for (char c: s.toCharArray()) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }

            Set<Integer> frequencies = new HashSet<>(counts.values());
            return frequencies.size() == 1;
        }
}
