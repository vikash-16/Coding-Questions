package LeetCode_Crash_Course.Hashing;

import java.util.*;

public class DetermineIfTwoStringareClose {
    public static void main(String[] args) {
        String word1 = "cabbba", word2 = "abbccc";
        System.out.println(closeStrings(word1,word2));
    }
    public static boolean closeStrings(String word1, String word2) {
        int [] count1 = new int[26];
        int [] count2 = new int[26];
        for(Character c: word1.toCharArray()) {
            count1[c-'a']++;
        }
        for(Character c: word2.toCharArray()) {
            count2[c-'a']++;
        }
        int[] array = Arrays.stream(count1).filter(i -> i != 0).sorted().toArray();
        int[] array1 = Arrays.stream(count2).filter(i -> i != 0).sorted().toArray();
        int[] array2 = Arrays.stream(count1).map(i -> i != 0 ? 1 : 0).toArray();
        int[] array3 = Arrays.stream(count2).map(i -> i != 0 ? 1 : 0).toArray();
        return Arrays.equals(array,array1) && Arrays.equals(array2,array3);
    }

}
