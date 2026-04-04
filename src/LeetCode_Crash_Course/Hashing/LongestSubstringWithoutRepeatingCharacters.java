package LeetCode_Crash_Course.Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> counts = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        char[] str = s.toCharArray();
        for(int right = 0; right < s.length(); right++) {
            while(counts.contains(str[right])) {
                counts.remove(str[left++]);
            }
            counts.add(str[right]);
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}
