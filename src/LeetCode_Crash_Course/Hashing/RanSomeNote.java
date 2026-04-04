package LeetCode_Crash_Course.Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class RanSomeNote {
    public static void main(String[] args) {
        String ransomNote = "anonymous";
        String magazine = "asansdondfymdfousdd";
        System.out.println(canConstruct(ransomNote,magazine));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        int [] magazineFreeq = new int[26];
        Arrays.fill(magazineFreeq,0);
        for(char c : magazine.toCharArray()) {
            magazineFreeq[c-'a']++;
        }
        for(char c : ransomNote.toCharArray()) {
            if(magazineFreeq[c-'a'] == 0) {
                return false;
            }
            magazineFreeq[c-'a']--;
        }
        return true;
    }
}
