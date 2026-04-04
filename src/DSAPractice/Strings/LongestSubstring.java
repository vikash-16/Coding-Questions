package DSAPractice.Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring { //longest substring
    public static void main(String[] args) {
        String s = "ddb";
        System.out.println(longestSubStribg(s));
    }

    private static int longestSubStribg(String s) {
        Map<Character,Integer>dict = new HashMap<>();
        int maxCount = 0;
        int left = 0,right = 0;
        while (left < s.length() && right < s.length()) {
            if (dict.get(s.charAt(right)) == null) {
                dict.put(s.charAt(right), 1);
                maxCount = Math.max(maxCount, right - left + 1);
                right++;
            } else {
                dict.put(s.charAt(left), dict.get(s.charAt(left)) - 1);
                if (dict.get(s.charAt(left)) == 0) {
                    dict.remove(s.charAt(left));
                }
                left++;
            }
        }
        return maxCount;
    }
}

