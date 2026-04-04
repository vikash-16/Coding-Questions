package LeetCode_Crash_Course.Hashing;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1,s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        int [] count1 = new int[26];
        int []count2 = new int [26];
        if(s1.length() > s2.length()) return false;
        for(int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        for(int i = 0; i < s2.length()-s1.length(); i++) {
            if(isMatched(count1,count2)) return true;
            count2[s2.charAt(i+s1.length())-'a']++;
            count2[s2.charAt(i)-'a']--;
        }
        return isMatched(count1,count2);
    }

    private static Boolean isMatched(int[] count1, int[] count2) {
        for(int i = 0; i < 26; i++) {
            if(count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}
