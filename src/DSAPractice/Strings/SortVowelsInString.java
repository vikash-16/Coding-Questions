package DSAPractice.Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SortVowelsInString {
    public static void main(String[] args) {
        String s = "lEetcOde";
        System.out.println(new SortVowelsInString().sortVowels(s));
    }
    public String sortVowels(String s) {
        Set<Character> dict = Set.of('A','E','I','O','U','a','e','i','o','u');
        char[] result = s.toCharArray();
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(dict.contains(result[i])) {
                while (!dict.contains(charArray[j])) {
                    j++;
                }
                result[i] = charArray[j++];
            }
        }
        return String.valueOf(result);
    }
}
