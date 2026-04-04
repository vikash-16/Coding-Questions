package LeetCode75.Arrays_String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfString {
    public static void main(String[] args) {
        String string = reverseVowels("IceCreAm");
        System.out.println(string);
    }
    public static String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a','e','i','o','u');
        int i = 0, j = s.length()-1;
        char[] charArray = s.toCharArray();
        while(i < j) {
            if(vowels.contains(Character.toLowerCase(charArray[i])) && vowels.contains(Character.toLowerCase(charArray[j]))) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++;
                j--;
            }else if (!vowels.contains(Character.toLowerCase(charArray[i]))){
                i++;
            }else {
                j--;
            }
        }
        return String.valueOf(charArray);

        /*StringBuilder str = new StringBuilder();
        char[] charArray = s.toCharArray();
        for(Character c : charArray) {
            if(vowels.contains(Character.toLowerCase(c))) {
                str.append(c);
            }
        }
        StringBuilder reverse = str.reverse();
        int j = 0;
        for(int i = 0; i < charArray.length; i++) {
            if(vowels.contains(Character.toLowerCase(charArray[i]))) {
                charArray[i] = reverse.charAt(j++);
            }
        }

        return String.valueOf(charArray);*/
    }
}
