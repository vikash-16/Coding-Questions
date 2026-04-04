package DSAPractice.Strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
       String s = "bba", t = "ab";
        System.out.println(new MinimumWindowSubstring().minWindow(s,t));
    }
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        Map<Character,Integer>freq = new HashMap<>();
        for(Character c : t.toCharArray()) {
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        int start = 0,end = 0,minLength = Integer.MAX_VALUE, startInd = 0,count = t.length();
        while (end < s.length()) {
            if(freq.containsKey(s.charAt(end)) && freq.get(s.charAt(end)) > 0) {
                count--;
            }
            freq.put(s.charAt(end),freq.getOrDefault(s.charAt(end),0)-1);
            end++;
            while (count == 0) {
                if(end-start < minLength) {
                    startInd = start;
                    minLength = end-start;
                }
                if (freq.get(s.charAt(start)) == 0) {
                    count++;
                }
                freq.put(s.charAt(start),freq.getOrDefault(s.charAt(start),0)+1);
                start++;
            }

        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startInd,startInd+minLength);
    }
}
