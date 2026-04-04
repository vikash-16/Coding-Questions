package LeetCode_Crash_Course.Hashing;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagramsSolution2(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>dict = new HashMap<>();
        for(String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if(!dict.containsKey(key)) {
                dict.put(key,new ArrayList<>());
            }
            dict.get(key).add(s);
        }
        return new ArrayList<>(dict.values());
    }
    public static List<List<String>> groupAnagramsSolution2(String[] strs) {
        HashMap<String,List<String>>dict = new HashMap<>();
        int [] count = new int [26];
        for(String s : strs) {
            Arrays.fill(count,0);
            for(Character c : s.toCharArray()) {
                count[c-'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < 26; i++ ){
                stringBuilder.append('*');
                stringBuilder.append(count[i]);
            }
            String key = stringBuilder.toString();
            if(!dict.containsKey(key)) {
                dict.put(key,new ArrayList<>());
            }
            dict.get(key).add(s);
        }
        return new ArrayList<>(dict.values());
    }
}
