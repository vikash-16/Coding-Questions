package DSAPractice.Strings;

import java.util.Map;

public class MinimumNumberofStepstoMakeTwoStringsAnagram {
    public static void main(String[] args) {
        String s = "bab", t = "aba";
        System.out.println(new MinimumNumberofStepstoMakeTwoStringsAnagram().minSteps(s,t));
    }
    public int minSteps(String s, String t) {
        int [] freq1 = new int [26];
        int [] freq2 = new int[26];
        char[] array = s.toCharArray();
        char[] array1 = t.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            freq1[array[i]-'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            freq2[array1[i]-'a']++;
        }
        int res = 0;
        for(int i = 0; i < 26; i++) {
            res+= Math.min(freq1[i],freq2[i]);
        }
        return t.length()-res;
    }
}
