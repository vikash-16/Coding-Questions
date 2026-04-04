package LeetCode_Crash_Course.Hashing;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort_Solution1(s));
        System.out.println(frequencySort_Solution2(s));
        System.out.println(frequencySort_Solution3(s));
    }
    public static String frequencySort_Solution1(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        List<String> uniqueCharString = new ArrayList<>();
        StringBuilder currString = new StringBuilder();
        currString.append(charArray[0]);
        for(int i = 1; i < charArray.length; i++) {
            if(charArray[i-1] != charArray[i]) {
                uniqueCharString.add(currString.toString());
                currString = new StringBuilder();
            }
            currString.append(charArray[i]);
        }
        uniqueCharString.add(currString.toString());
        Collections.sort(uniqueCharString,(a,b)->b.length()-a.length());
        StringBuilder newString = new StringBuilder();
        for(String str : uniqueCharString) {
            newString.append(str);
        }
        return newString.toString();
    }

    public static String frequencySort_Solution2(String s) {
        HashMap<Character,Integer>freqCount = new HashMap<>();
        for(Character c : s.toCharArray()) {
            freqCount.put(c,freqCount.getOrDefault(c,0)+1);
        }
        ArrayList<Character> characters = new ArrayList<>(freqCount.keySet());
        Collections.sort(characters,(a,b)->freqCount.get(b)-freqCount.get(a));
        StringBuilder sb = new StringBuilder();
        for(Character c : characters) {
            Integer len = freqCount.get(c);
            for(int i = 0; i < len; i++ ){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static String frequencySort_Solution3(String s) {
        HashMap<Character,Integer>freqCount = new HashMap<>();
        for(Character c : s.toCharArray()) {
            freqCount.put(c,freqCount.getOrDefault(c,0)+1);
        }
        Integer maxFreq = Collections.max(freqCount.values());
        List<List<Character>>bucket = new ArrayList<>();
        for(int i = 0; i <= maxFreq; i++) {
            bucket.add(new ArrayList<>());
        }
        for(Character c : freqCount.keySet()) {
            Integer count = freqCount.get(c);
            bucket.get(count).add(c);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = bucket.size()-1; i >= 1; i--) {
            for(Character c : bucket.get(i)) {
                for(int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
