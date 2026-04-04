package DSAPractice.Strings;

import java.text.CollationElementIterator;
import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
       String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(new GroupAnagram().groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = Arrays.stream(strs).collect(
                        HashMap::new,
                        (map, s) -> {
                            char[] array = s.toCharArray();
                            Arrays.sort(array);
                            String string = new String(array);
                            map.computeIfAbsent(string, k -> new ArrayList<>()).add(s);
                        },
                        HashMap::putAll
                );
        return new ArrayList<>(mp.values());

    }
}
