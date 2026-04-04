package LeetCode_Crash_Course.Hashing;

import java.util.HashMap;

public class IsIsoMorphic {
    public static void main(String[] args) {
        String s1 = "eggh",s2 = "addf";
        System.out.println(isIsomorphic(s1,s2));

    }
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer>h1 = new HashMap<>();
        HashMap<Character,Integer>h2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(h1.put(s.charAt(i),i) != h2.put(t.charAt(i),i)){
                return false;
            }
        }
        return true;
    }
}
