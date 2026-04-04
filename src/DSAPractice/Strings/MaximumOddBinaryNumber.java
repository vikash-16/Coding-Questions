package DSAPractice.Strings;

import java.util.Arrays;

public class MaximumOddBinaryNumber {
    public static void main(String[] args) {
        String s = "0101";
        System.out.println(new MaximumOddBinaryNumber().maximumOddBinaryNumber(s));
    }
    public String maximumOddBinaryNumber(String s) {
        if(s.length() == 0 || s.length() == 1) {
            return s;
        }
        int ones = 0;
        StringBuilder str = new StringBuilder();
        for(Character c : s.toCharArray()) {
            if(c == '1') {
                ones++;
            }
        }
        for(int i = 0; i < s.length(); i++,ones--) {
            str.append(ones > 1 ? '1': '0');
        }
        str.deleteCharAt(str.length()-1);
        str.append('1');
        return str.toString();

    }
}
