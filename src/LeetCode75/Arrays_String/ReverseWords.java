package LeetCode75.Arrays_String;

import java.util.Arrays;

public class ReverseWords {
    public static void main(String[] args) {
        String string = reverseWords("the   sky is blue");
        System.out.println(string);
    }
    public static String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        String result = "";
        for(int i = split.length-1;i > 0;i-- ) {
            result += split[i]+" ";
        }
        return result+split[0];
    }

}
