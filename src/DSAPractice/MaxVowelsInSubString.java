package DSAPractice;

import java.util.Arrays;
import java.util.HashSet;

public class MaxVowelsInSubString {
    public static void main(String[] args) {
        String s = "abciiidef";
        System.out.println(maxVowels(s,3));
    }
    public static int maxVowels(String s, int k) {
        char[] str = s.toCharArray();
        int vowelCount = 0;
        HashSet<Character>dictVowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        for(int i = 0; i < k; i++) {
            if(dictVowels.contains(str[i])) {
                vowelCount++;
            }
        }
        int maxVowelCount = vowelCount;
        int left = 0,right = k;
        while(right < s.length()) {
            if(dictVowels.contains(str[left])) {
                vowelCount--;
            }
            left++;
            if(dictVowels.contains(str[right])) {
                vowelCount++;
            }
            right++;
            maxVowelCount = Math.max(maxVowelCount,vowelCount);
        }
        return maxVowelCount;
    }
}
