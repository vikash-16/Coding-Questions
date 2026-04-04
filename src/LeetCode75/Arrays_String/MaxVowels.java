package LeetCode75.Arrays_String;

import java.util.HashSet;
import java.util.Set;

public class MaxVowels {
    public static void main(String[] args) {
        MaxVowels maxVowels = new MaxVowels();
        System.out.println(maxVowels.maxVowels("abciiidef",3));
    }
    public int maxVowels(String s, int k) {
        Set<Character> set = Set.of('a','e','i','o','u');
        int maxVowels = Integer.MIN_VALUE;
        int currentVowels = 0;
        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            if(j < k) {
                if(set.contains(s.charAt(j))) {
                    currentVowels++;
                    maxVowels = Math.max(maxVowels,currentVowels);
                }
            }else {
                if(set.contains(s.charAt(j))){
                    currentVowels++;
                }
                if(set.contains(s.charAt(i))) {
                    currentVowels--;
                }
                i++;
                maxVowels = Math.max(maxVowels,currentVowels);
            }
        }
        return maxVowels;
    }
}
