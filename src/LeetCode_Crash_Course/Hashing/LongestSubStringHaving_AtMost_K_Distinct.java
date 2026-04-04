package LeetCode_Crash_Course.Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStringHaving_AtMost_K_Distinct {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(findLongestSubstring(s, k));
    }

    private static int findLongestSubstring(String s, int k) {
        HashMap<Character, Integer> counts = new HashMap<>();
        int left = 0, ans = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
            while (counts.size() > k) {
                char c1 = s.charAt(left);
                counts.put(c, counts.getOrDefault(c1, 0) - 1);
                if (counts.get(c1) == 0) {
                    counts.remove(c1);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
