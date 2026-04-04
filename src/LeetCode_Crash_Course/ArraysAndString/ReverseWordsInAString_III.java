package LeetCode_Crash_Course.ArraysAndString;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsInAString_III {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));

    }
    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        List<String> collect = Arrays.stream(str).map(x-> reverseString(x.toCharArray())).collect(Collectors.toList());
        return String.join(" ", collect);
    }

    private static String reverseString(char[] charArray) {
        int left = 0, right = charArray.length-1;
        while(left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
}
