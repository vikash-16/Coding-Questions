package DSAPractice.Arrays;

import java.util.ArrayList;
import java.util.List;

public class RemoveDigitFromNumbar {
    public static void main(String[] args) {
        String number = "1231";
        char digit = '1';
        System.out.println(new RemoveDigitFromNumbar().removeDigit(number,digit));
    }
    public String removeDigit(String number, char digit) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < number.length(); i++ ) {
            if(number.charAt(i) == digit && number.charAt(i+1) > digit) {
                String s = number.substring(0, i) + number.substring(i + 1, number.length());
//                result.add(s);
                return s;
            }
        }
        int i = number.lastIndexOf(digit);
        return number.substring(0,i)+number.substring(i+1,number.length());
    }
}
