package DSAPractice.Strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        String s = "aabca";
        int i = new UniqueLength3PalindromicSubsequences().countPalindromicSubsequence(s);
        System.out.println(i);
    }
    public int countPalindromicSubsequence(String s) {
        int count = 0;
        for(int i = 0; i < 26; i++) {
            int start = s.indexOf(i + 'a');
            int end = s.lastIndexOf(i + 'a');
            if(end == -1) continue;
            Set<Character> uniqueInBetween = new HashSet<>();
            for(int k = start+1; k < end; k++) {
                uniqueInBetween.add(s.charAt(k));
            }
            count+=uniqueInBetween.size();
        }
        return count;
    }
}
